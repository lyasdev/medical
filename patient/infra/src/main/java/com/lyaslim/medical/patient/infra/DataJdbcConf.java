package com.lyaslim.medical.patient.infra;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import com.lyaslim.medical.patient.domain.model.Sexe;

@Configuration
public class DataJdbcConf extends AbstractJdbcConfiguration {
    @Override
    public JdbcCustomConversions jdbcCustomConversions() {

        return new JdbcCustomConversions(List.of(SexeWriter.INSTANCE,SexeReader.INSTANCE));

    }

    @WritingConverter
    enum SexeWriter implements Converter<Sexe, String> {

        INSTANCE;

        @Override
        public String convert(Sexe source) {
             return String.valueOf(source.getId());
        }

    }
    @ReadingConverter
    enum SexeReader implements Converter<Integer, Sexe> {

        INSTANCE;

        @Override
        public Sexe convert(Integer source) {
            return Sexe.from(source);
        }

    }
}
