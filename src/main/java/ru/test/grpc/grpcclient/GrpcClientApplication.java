package ru.test.grpc.grpcclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.grpc.grpcclient.domain.BankAccountInfo;
import ru.test.grpc.grpcclient.service.GrpcClientService;

@SpringBootApplication
public class GrpcClientApplication implements CommandLineRunner {

	@Autowired
	GrpcClientService grpcClientService;

	public static void main(String[] args) {
		SpringApplication.run(GrpcClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BankAccountInfo bankAccountInfo = grpcClientService.getBankAccountInfo("DEBIT");
		System.out.println("BANK:" + bankAccountInfo);
	}
}
