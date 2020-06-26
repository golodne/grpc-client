package ru.test.grpc.grpcclient.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.grpc.grpcclient.domain.BankAccountInfo;
import ru.test.grpc.grpcclient.service.GrpcClientService;

@RestController
@RequestMapping("/bank-account")
public class GRPCBankAccountController {

    private final GrpcClientService grpcClientService;

    public GRPCBankAccountController(@Autowired GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @GetMapping("/{type}")
    public BankAccountInfo getBook(@PathVariable String type) {
        return grpcClientService.getBankAccountInfo(type);
    }
}
