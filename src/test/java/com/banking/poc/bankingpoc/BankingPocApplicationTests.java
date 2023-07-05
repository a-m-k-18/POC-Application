package com.banking.poc.bankingpoc;

import com.banking.poc.bankingpoc.controller.AccountController;
import com.banking.poc.bankingpoc.dto.AccountDto;
import com.banking.poc.bankingpoc.entity.Account;
import com.banking.poc.bankingpoc.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@WebFluxTest(controllers = AccountController.class)
class BankingPocApplicationTests {


}