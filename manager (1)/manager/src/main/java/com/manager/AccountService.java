package com.manager;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AccountService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    public Account createAccount(Account account) {
//        return accountRepository.save(account);
//    }
//
//    public Optional<Account> getAccount(Long id) {
//        return accountRepository.findById(id);
//    }
//
//    public Account deposit(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
//        account.setBalance(account.getBalance() + amount);
//        return accountRepository.save(account);
//    }
//
//    public Account withdraw(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
//        if (account.getBalance() < amount) {
//            throw new RuntimeException("Insufficient funds");
//        }
//        
//        account.setBalance(account.getBalance() - amount);
//        return accountRepository.save(account);
//    }
//
//	public List<Account> getAllCustomers() {
//		 
//		        return accountRepository.findAll();
//		    }
//
//	public void deleteAccountById(Long accountId) {
//		
//	        accountRepository.deleteById(accountId);
//	    }
//		
//	}



// below code is working upto inertnal server error 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AccountService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    public Account createAccount(Account account) {
//        return accountRepository.save(account);
//    }
//
//    public Optional<Account> getAccount(Long id) {
//        return accountRepository.findById(id);
//    }
//
//    public Account deposit(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
//        account.setBalance(account.getBalance() + amount);
//        return accountRepository.save(account);
//    }
//
//    public Account withdraw(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
//        if (account.getBalance() < amount) {
//            throw new InsufficientFundsException("Insufficient funds");
//        }
//
//        account.setBalance(account.getBalance() - amount);
//        return accountRepository.save(account);
//    }
//
//    public List<Account> getAllCustomers() {
//        return accountRepository.findAll();
//    }
//
//    public void deleteAccountById(Long accountId) {
//        accountRepository.deleteById(accountId);
//    }
//
//    // Custom exception for resource not found
//    public static class ResourceNotFoundException extends RuntimeException {
//        public ResourceNotFoundException(String message) {
//            super(message);
//        }
//    }
//
//    // Custom exception for insufficient funds
//    public static class InsufficientFundsException extends RuntimeException {
//        public InsufficientFundsException(String message) {
//            super(message);
//        }
//    }
//}


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AccountService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    public Account createAccount(Account account) {
//        return accountRepository.save(account);
//    }
//
//    public Optional<Account> getAccount(Long id) {
//        return accountRepository.findById(id);
//    }
//
//    public Account deposit(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
//        account.setBalance(account.getBalance() + amount);
//        return accountRepository.save(account);
//    }
//
//    public Account withdraw(Long id, double amount) {
//        Account account = getAccount(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
//        if (account.getBalance() < amount) {
//            throw new InsufficientFundsException("Insufficient funds");
//        }
//
//        account.setBalance(account.getBalance() - amount);
//        return accountRepository.save(account);
//    }
//
//    public ResponseEntity<ApiResponse<Object>> getAllAccounts() {
//        try {
//            List<Account> accounts = accountRepository.findAll();
//            return new ResponseEntity<>(new ApiResponse<>(accounts, "Success", true), HttpStatus.OK);
//        } catch (NetworkException ne) {
//            // Handle network-related exception
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ApiResponse<>(null, "Network error occurred while fetching customer accounts", false));
//        } catch (IncorrectEndpointException ie) {
//            // Handle incorrect endpoint exception
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ApiResponse<>(null, "Incorrect endpoint for fetching customer accounts", false));
//        } catch (Exception e) {
//            // Handle other exceptions
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ApiResponse<>(null, "An error occurred: " + e.getMessage(), false));
//        }
//    }
//
//    public void deleteAccountById1(Long accountId) {
//        accountRepository.deleteById(accountId);
//    }
//
//    // Custom exception for resource not found
//    public static class ResourceNotFoundException extends RuntimeException {
//        public ResourceNotFoundException(String message) {
//            super(message);
//        }
//    }
//
//    // Custom exception for insufficient funds
//    public static class InsufficientFundsException extends RuntimeException {
//        public InsufficientFundsException(String message) {
//            super(message);
//        }
//    }
//
//    // Custom exception for network error
//    public static class NetworkException extends RuntimeException {
//        public NetworkException(String message) {
//            super(message);
//        }
//    }
//
//    // Custom exception for incorrect endpoint
//    public static class IncorrectEndpointException extends RuntimeException {
//        public IncorrectEndpointException(String message) {
//            super(message);
//        }
//    }
//}



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        try {
            return accountRepository.save(account);
        } catch (Exception e) {
            handleNetworkError(e);
            throw new NetworkException("Error creating account", e);
        }
    }

    public Optional<Account> getAccount(Long id) {
        try {
            return accountRepository.findById(id);
        } catch (Exception e) {
            handleNetworkError(e);
            throw new NetworkException("Error retrieving account with ID: " + id, e);
        }
    }

    public Account deposit(Long id, double amount) {
        try {
            Account account = getAccount(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
            account.setBalance(account.getBalance() + amount);
            return accountRepository.save(account);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (InsufficientFundsException e) {
            throw e;
        } catch (Exception e) {
            handleNetworkError(e);
            throw new NetworkException("Error depositing into account with ID: " + id, e);
        }
    }

    public Account withdraw(Long id, double amount) {
        try {
            Account account = getAccount(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
            if (account.getBalance() < amount) {
                throw new InsufficientFundsException("Insufficient funds");
            }
            account.setBalance(account.getBalance() - amount);
            return accountRepository.save(account);
        } catch (Exception e) {
            handleNetworkError(e);
            throw new NetworkException("Error withdrawing from account with ID: " + id, e);
        }
    }

    public ResponseEntity<ApiResponse<Object>> getAllAccounts() {
        try {
            List<Account> accounts = accountRepository.findAll();
            return new ResponseEntity<>(new ApiResponse<>(accounts, "Success", true), HttpStatus.OK);
        } catch (NetworkException ne) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(null, "Network error occurred while fetching accounts", false));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(null, "An error occurred: " + e.getMessage(), false));
        }
    }

    public void deleteAccountById(Long accountId) {
        try {
            accountRepository.deleteById(accountId);
        } catch (Exception e) {
            handleNetworkError(e);
            throw new NetworkException("Error deleting account with ID: " + accountId, e);
        }
    }

    private void handleNetworkError(Exception e) {
        // Log the error using a logging framework like SLF4J
        System.err.println("Network-related error: " + e.getMessage());
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    public static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public static class NetworkException extends RuntimeException {
        public NetworkException(String message, Exception e) {
            super(message, e);
        }
    }
}



	
	