package com.tesobe.obp.api;

import com.tesobe.obp.clientapi.ObpApiClient;
import com.tesobe.obp.clientapi.ObpBankMetaApiClient;
import com.tesobe.obp.domain.ATM;
import com.tesobe.obp.domain.Bank;
import com.tesobe.obp.domain.Branch;
import com.tesobe.obp.domain.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class BanksController {


    @Autowired  private ObpBankMetaApiClient obpBankMetaApiClient;
    @Autowired private ObpApiClient obpApiClient;

    Logger logger = Logger.getLogger(BanksController.class.getName());

    @GetMapping("/branches")
    public List<Branch> allBranches() {
        ObpBankMetaApiClient.Banks allBanks = obpBankMetaApiClient.getBanks();
        logger.info("Fetching branches for " + allBanks);
        return allBanks.getBanks().stream().map(bank -> obpBankMetaApiClient.getBranches(bank.getId()).getBranches())
                .filter(branches -> branches.size() > 0)   //exclude empty branch lists
        .flatMap(Collection::stream).collect(Collectors.toList());
    }

    @GetMapping("/atms")
    public List<ATM> allAtms() {
        List<Bank> allBanks = obpBankMetaApiClient.getBanks().getBanks();
        return allBanks.stream().map(bank -> obpBankMetaApiClient.getAtms(bank.getId()).getAtms())
                .filter(branches -> branches.size() > 0)   //exclude empty branch lists
                .flatMap(Collection::stream).collect(Collectors.toList());
    }


    
    @GetMapping("/transactions/{bankId}/{accountId}")
    public List<Transaction> allTransactions(@PathVariable("bankId") String bankId,
                                             @PathVariable("accountId") String accountId) {
        List<Transaction> allBanks = (List<Transaction>) obpApiClient.getTransactionsForAccount(bankId, accountId);
        return allBanks;
    }

}
