package ru.test.grpc.grpcclient.service.mapping;

import net.badata.protobuf.converter.Converter;
import org.springframework.stereotype.Service;
import ru.grpc.model.AccountType;
import ru.grpc.model.BankAccountInfoRequest;
import ru.grpc.model.BankAccountInfoResponse;
import ru.test.grpc.grpcclient.domain.Address;
import ru.test.grpc.grpcclient.domain.BankAccountInfo;

@Service
public class GrpcMapperImpl implements GrpcMapper {
    @Override
    public BankAccountInfoRequest toBankAccountInfoRequest(String type) {
        //convert domain model to grpc model
        AccountType accountType = AccountType.newBuilder()
                .setType(type)
                .build();

        BankAccountInfoRequest bankAccountInfoRequest = BankAccountInfoRequest.newBuilder()
                .setAccountType(accountType)
                .build();
        return bankAccountInfoRequest;
    }

    @Override
    public BankAccountInfo grpcRespnseToDomainRespnse(BankAccountInfoResponse responseServer) {

        //?? есть еще такие преобразования, пока не разобрался, может у тебя получится :)
        //BankAccountInfo bankAccountInfo = Converter.create().toDomain(BankAccountInfo.class, responseServer);

        Address address = Address.builder()
                .city(responseServer.getBankAccountInfo().getAddress().getCity())
                .street(responseServer.getBankAccountInfo().getAddress().getStreet())
                .state(responseServer.getBankAccountInfo().getAddress().getState())
                .build();

        BankAccountInfo bankAccountInfo = BankAccountInfo.builder()
                .address(address)
                .build();

        return bankAccountInfo;
    }
}
