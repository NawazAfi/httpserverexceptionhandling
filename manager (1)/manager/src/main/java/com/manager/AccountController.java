package com.manager;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/accounts")
//public class AccountController {
//
//    @Autowired
//    private AccountService accountService;
//
//    @PostMapping
//    public Account createAccount(@RequestBody Account account) {
//        return accountService.createAccount(account);
//    }
//
//    @GetMapping("/{id}")
//    public Account getAccount(@PathVariable Long id) {
//        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
//    }
//
//    
//    
//    @GetMapping
//    public ResponseEntity<List<Account>> getAllAccounts() {
//        List<Account> customers = accountService.getAllCustomers();
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
//    
//    
//    @DeleteMapping("/{accountId}")
//    public ResponseEntity<Void> deleteAccountById(@PathVariable Long accountId) {
//        accountService.deleteAccountById(accountId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    
//    
//    
//    @PostMapping("/{id}/deposit")
//    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        Double amount = request.get("amount");
//        return accountService.deposit(id, amount);
//    }
//
//    @PostMapping("/{id}/withdraw")
//    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        Double amount = request.get("amount");
//        return accountService.withdraw(id, amount);
//    }
//}

// below code working upto internal server excuaption hadling


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/accounts")
//public class AccountController {
//
//    @Autowired
//    private AccountService accountService;
//
//    @PostMapping
//    public ResponseEntity<?> createAccount(@RequestBody Account account) {
//        try {
//            Account createdAccount = accountService.createAccount(account);
//            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getAccount(@PathVariable Long id) {
//        try {
//            Account account = accountService.getAccount(id).orElseThrow(() -> new AccountService.ResourceNotFoundException("Account not found"));
//            return new ResponseEntity<>(account, HttpStatus.OK);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<?> getAllAccounts() {
//        try {
//            List<Account> accounts = accountService.getAllCustomers();
//            return new ResponseEntity<>(accounts, HttpStatus.OK);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @DeleteMapping("/{accountId}")
//    public ResponseEntity<?> deleteAccountById(@PathVariable Long accountId) {
//        try {
//            accountService.deleteAccountById(accountId);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @PostMapping("/{id}/deposit")
//    public ResponseEntity<?> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        try {
//            Double amount = request.get("amount");
//            Account depositedAccount = accountService.deposit(id, amount);
//            return new ResponseEntity<>(depositedAccount, HttpStatus.OK);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @PostMapping("/{id}/withdraw")
//    public ResponseEntity<?> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        try {
//            Double amount = request.get("amount");
//            Account withdrawnAccount = accountService.withdraw(id, amount);
//            return new ResponseEntity<>(withdrawnAccount, HttpStatus.OK);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    private ResponseEntity<?> handleException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ApiResponse("An error occurred: " + e.getMessage(), false));
//    }
//}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/accounts")
//public class AccountController {
//
//    @Autowired
//    private AccountService accountService;
//
//    @PostMapping
//    public ResponseEntity<?> createAccount(@RequestBody Account account) {
//        try {
//            Account createdAccount = accountService.createAccount(account);
//            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getAccount(@PathVariable Long id) {
//        try {
//            Account account = accountService.getAccount(id).orElseThrow(() -> new AccountService.ResourceNotFoundException("Account not found"));
//            return new ResponseEntity<>(account, HttpStatus.OK);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    
//    
//    
//    
//    
//    @GetMapping
//    public ResponseEntity<?> getAllAccounts() {
//        try {
//            return accountService.getAllAccounts();
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//
//    
//    
//    
//    
//    
//    
//
//    @DeleteMapping("/{accountId}")
//    public ResponseEntity<?> deleteAccountById(@PathVariable Long accountId) {
//        try {
//            accountService.deleteAccountById1(accountId);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @PostMapping("/{id}/deposit")
//    public ResponseEntity<?> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        try {
//            Double amount = request.get("amount");
//            Account depositedAccount = accountService.deposit(id, amount);
//            return new ResponseEntity<>(depositedAccount, HttpStatus.OK);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    @PostMapping("/{id}/withdraw")
//    public ResponseEntity<?> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        try {
//            Double amount = request.get("amount");
//            Account withdrawnAccount = accountService.withdraw(id, amount);
//            return new ResponseEntity<>(withdrawnAccount, HttpStatus.OK);
//        } catch (Exception e) {
//            return handleException(e);
//        }
//    }
//
//    private ResponseEntity<?> handleException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ApiResponse("An error occurred: " + e.getMessage(), null, false));
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(new ApiResponse<>(accountService.createAccount(account), "Account created successfully", true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(accountService.getAccount(id), "Account retrieved successfully", true));
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<ApiResponse<Object>> deposit(@PathVariable Long id, @RequestParam double amount) {
        return ResponseEntity.ok(new ApiResponse<>(accountService.deposit(id, amount), "Amount deposited successfully", true));
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<ApiResponse<Object>> withdraw(@PathVariable Long id, @RequestParam double amount) {
        return ResponseEntity.ok(new ApiResponse<>(accountService.withdraw(id, amount), "Amount withdrawn successfully", true));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "Account deleted successfully", true));
    }
}

