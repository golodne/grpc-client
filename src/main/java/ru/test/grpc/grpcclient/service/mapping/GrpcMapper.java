package ru.test.grpc.grpcclient.service.mapping;

import ru.grpc.model.BankAccountInfoRequest;
import ru.grpc.model.BankAccountInfoResponse;
import ru.test.grpc.grpcclient.domain.BankAccountInfo;

public interface GrpcMapper {

    //domain request to grpc request
    BankAccountInfoRequest toBankAccountInfoRequest(String type);

    //grpc response to domain response
    BankAccountInfo grpcRespnseToDomainRespnse(BankAccountInfoResponse responseServer);
}
