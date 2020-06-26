package ru.test.grpc.grpcclient.service;

import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;
import ru.grpc.model.BankAccountInfoRequest;
import ru.grpc.model.BankAccountInfoResponse;
import ru.grpc.model.BankAccountInfoServiceGrpc;
import ru.test.grpc.grpcclient.domain.BankAccountInfo;
import ru.test.grpc.grpcclient.service.mapping.GrpcMapper;

@Service
public class GrpcClientService {

    private final GrpcMapper grpcMapper;

    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    public GrpcClientService(GrpcMapper grpcMapper) {
        this.grpcMapper = grpcMapper;
    }

    public BankAccountInfo getBankAccountInfo(String type) {

        BankAccountInfoServiceGrpc.BankAccountInfoServiceBlockingStub stub = BankAccountInfoServiceGrpc.newBlockingStub(serverChannel);

        //преобразовали в запрос к grpc серверу в его формате
        BankAccountInfoRequest bankAccountInfoRequest = grpcMapper.toBankAccountInfoRequest(type);

        System.out.println("send to grpc server");
        //call method on grpc server
        BankAccountInfoResponse responseGrpcServer = stub.sendAccount(bankAccountInfoRequest);

        //convert grpc model to domain model
        BankAccountInfo bankAccountInfo = grpcMapper.grpcRespnseToDomainRespnse(responseGrpcServer);

        return bankAccountInfo;
    }
}
