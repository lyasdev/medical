package com.lyaslim.medical.patient.infra;

import java.util.List;

import com.lyaslim.medical.patient.domain.model.BloodGroup;
import com.lyaslim.medical.patient.domain.model.TypeTraitement;
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

        return new JdbcCustomConversions(List.of(SexeWriter.INSTANCE, SexeReader.INSTANCE, BloodWriter.INSTANCE,
                BloodReader.INSTANCE, TypeTrtReader.INSTANCE, TypeTrtWriter.INSTANCE));

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

    //
    @WritingConverter
    enum BloodWriter implements Converter<BloodGroup, String> {

        INSTANCE;

        @Override
        public String convert(BloodGroup source) {
            return String.valueOf(source.getId());
        }

    }

    @ReadingConverter
    enum BloodReader implements Converter<Integer, BloodGroup> {

        INSTANCE;

        @Override
        public BloodGroup convert(Integer source) {
            return BloodGroup.from(source);
        }

    }

    //
    @WritingConverter
    enum TypeTrtWriter implements Converter<TypeTraitement, String> {

        INSTANCE;

        @Override
        public String convert(TypeTraitement source) {
            return String.valueOf(source.getId());
        }

    }

    @ReadingConverter
    enum TypeTrtReader implements Converter<Integer, TypeTraitement> {

        INSTANCE;

        @Override
        public TypeTraitement convert(Integer source) {
            return TypeTraitement.from(source);
        }

    }
}
