package ru.test.grpc.grpcclient.domain;

import lombok.*;
import net.badata.protobuf.converter.annotation.ProtoClass;
import net.badata.protobuf.converter.annotation.ProtoField;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ProtoClass(ru.grpc.model.BankAccountInfo.class)
public class BankAccountInfo {
    @ProtoField
    private Address address;
}
