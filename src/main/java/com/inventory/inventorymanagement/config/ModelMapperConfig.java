package com.inventory.inventorymanagement.config;

import com.inventory.inventorymanagement.dto.*;
import com.inventory.inventorymanagement.entity.Bolt;
import com.inventory.inventorymanagement.entity.Hose;
import com.inventory.inventorymanagement.entity.Oil;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private static final Converter<BoltRequestDTO, Bolt> BOLT_REQUEST_DTO_BOLT_CONVERTER = mappingContext -> {
        Bolt bolt = new Bolt();
        BoltRequestDTO boltRequestDTO = mappingContext.getSource();
        bolt.setName(boltRequestDTO.getName());
        bolt.setType(boltRequestDTO.getType());
        bolt.setLength(boltRequestDTO.getLength());
        bolt.setThickness(boltRequestDTO.getThickness());
        return bolt;
    };

    private static final Converter<Bolt, BoltResponseDTO> BOLT_BOLT_RESPONSE_DTO_CONVERTER = mappingContext -> {
      BoltResponseDTO boltResponseDTO = new BoltResponseDTO();
      Bolt bolt = mappingContext.getSource();
        boltResponseDTO.setId(bolt.getId());
        boltResponseDTO.setName(bolt.getName());
        boltResponseDTO.setType(bolt.getType());
        boltResponseDTO.setLength(bolt.getLength());
        boltResponseDTO.setThickness(bolt.getThickness());
        return boltResponseDTO;

    };

    @Bean
    ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(BOLT_REQUEST_DTO_BOLT_CONVERTER,BoltRequestDTO.class,Bolt.class);
        modelMapper.addConverter(BOLT_BOLT_RESPONSE_DTO_CONVERTER,Bolt.class,BoltResponseDTO.class);
        return  modelMapper;
    }

    private static final Converter<OilRequestDTO, Oil> OIL_REQUEST_DTO_OIL_CONVERTER = mappingContext -> {
        Oil oil = new Oil();
        OilRequestDTO oilRequestDTO = mappingContext.getSource();
        oil.setName(oilRequestDTO.getName());
        oil.setBrand(oilRequestDTO.getBrand());
        return oil;
    };

    private static final Converter<Oil, OilResponseDTO> OIL_OIL_RESPONSE_DTO_CONVERTER = mappingContext -> {
        OilResponseDTO oilResponseDTO = new OilResponseDTO();
        Oil oil = mappingContext.getSource();
        oilResponseDTO.setName(oil.getName());
        oilResponseDTO.setBrand(oil.getBrand());
        return oilResponseDTO;

    };

    @Bean
    ModelMapper modelMapperOil(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(OIL_REQUEST_DTO_OIL_CONVERTER,OilRequestDTO.class,Oil.class);
        modelMapper.addConverter(OIL_OIL_RESPONSE_DTO_CONVERTER,Oil.class,OilResponseDTO.class);
        return  modelMapper;
    }

    private static final Converter<HoseRequestDTO, Hose> HOSE_REQUEST_DTO_HOSE_CONVERTER = mappingContext -> {
        Hose hose = new Hose();
        HoseRequestDTO hoseRequestDTO = mappingContext.getSource();
        hose.setName(hoseRequestDTO.getName());
        hose.setLength(hoseRequestDTO.getLength());
        hose.setThickness(hoseRequestDTO.getThickness());
        return hose;
    };

    private static final Converter<Hose, HoseResponseDTO> HOSE_HOSE_RESPONSE_DTO_CONVERTER = mappingContext -> {
        HoseResponseDTO hoseResponseDTO = new HoseResponseDTO();
        Hose hose = mappingContext.getSource();
        hoseResponseDTO.setName(hose.getName());
        hoseResponseDTO.setLength(hose.getLength());
        hoseResponseDTO.setThickness(hose.getThickness());
        return hoseResponseDTO;

    };

    @Bean
    ModelMapper modelMapperHose(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(HOSE_REQUEST_DTO_HOSE_CONVERTER,HoseRequestDTO.class,Hose.class);
        modelMapper.addConverter(HOSE_HOSE_RESPONSE_DTO_CONVERTER,Hose.class,HoseResponseDTO.class);
        return  modelMapper;
    }

}
