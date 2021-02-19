import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

const USERS = [
  {login: 'lyas', password: 'lyas'},
  {login: 'slimane', password: 'slimane'}
]

@Injectable({
  providedIn: 'root'
})
export class FakeBackEndService implements HttpInterceptor {

  constructor(@Inject('AUTHENTICATION_URL') private AUTHENTICATION_URL) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (req.method === 'POST' && req.url === this.AUTHENTICATION_URL) {
      const user = USERS.find(e => e.login === req.body.login && e.password === req.body.password );
      if (user) {
        return of(new HttpResponse({ status: 200, body: {token: 'Bearer 11111'} }));
      }
      return of(new HttpResponse({ status: 401, body: {message: 'unauthorized'} }));
    }
    next.handle(req);
  }
}
