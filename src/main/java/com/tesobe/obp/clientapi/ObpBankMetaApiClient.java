package com.tesobe.obp.clientapi;

import com.tesobe.obp.domain.ATM;
import com.tesobe.obp.domain.Bank;
import com.tesobe.obp.domain.Branch;
import lombok.Data;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="bank", url="${obp.api.versionedUrl}")
public interface ObpBankMetaApiClient {

    @RequestMapping(method = RequestMethod.GET, value ="/banks")
    Banks getBanks();

    //https://apisandbox.openbankproject.com/obp/v3.1.0/banks


    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/branches")
    Branches getBranches(@PathVariable("bankId") String bankId);

    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/branches/{branchId}")
    Branch getBranch(@PathVariable("bankId") String bankId, @PathVariable("branchId") String branchId);

    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/atms")
    ATMs getAtms(@PathVariable("bankId") String bankId);

    @RequestMapping(method = RequestMethod.GET, value = "banks/{bankId}/branches/{branchId}/atms/{atmId}")
    Branch getAtm(@PathVariable("bankId") String bankId, @PathVariable("branchId") String branchId, @PathVariable("atmId") String atmId);

    @Data  //@Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations on the class
    class Banks {
        private List<Bank> banks;

        public List<Bank> getBanks() {
            return banks;
        }

        public void setBanks(List<Bank> banks) {
            this.banks = banks;
        }
    }

    @Data
    class ATMs {
        private List<ATM> atms;

        public List<ATM> getAtms() {
            return atms;
        }

        public void setAtms(List<ATM> atms) {
            this.atms = atms;
        }
    }

    @Data
    class Branches {
        private List<Branch> branches;

        public List<Branch> getBranches() {
            return branches;
        }

        public void setBranches(List<Branch> branches) {
            this.branches = branches;
        }
    }

}
