import { HttpClient, HttpResponse } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { JwtHelperService } from './jwt-helper.service';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient,
              private jwtHelper: JwtHelperService,
              @Inject('AUTHENTICATION_URL') private AUTHENTICATION_URL,
              @Inject('TOKEN_KEY') private TOKEN_KEY) { }

  login(login:string, password:string): Observable<HttpResponse<any>> {
    return this.http.post<HttpResponse<any>>(this.AUTHENTICATION_URL, {login, password}, { observe: 'response' })
    .pipe(tap(e => this.processResponse(e)));
  }

  logout(): void {
    this.jwtHelper.remove(this.TOKEN_KEY);
  }

  isLoggedIn(): boolean {
    return this.jwtHelper.get(this.TOKEN_KEY) !== undefined && this.jwtHelper.get(this.TOKEN_KEY) !== null;
  }

  private processResponse(e: HttpResponse<any>): void {
    if (e.status !== 200) {
      throw new Error('Unauthorized');
    }
    this.jwtHelper.set(this.TOKEN_KEY, e.body.token);
  }
}
