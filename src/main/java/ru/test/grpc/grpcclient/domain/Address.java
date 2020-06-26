package ru.test.grpc.grpcclient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.badata.protobuf.converter.annotation.ProtoClass;
import net.badata.protobuf.converter.annotation.ProtoField;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ProtoClass(ru.grpc.model.Address.class)
@Builder
public class Address {
    @ProtoField
    private String street;
    @ProtoField
    private String city;
    @ProtoField
    private String state;
}
