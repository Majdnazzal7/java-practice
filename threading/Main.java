package threading;


import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // 1. Create Bank Account
        BankAccount account = new BankAccount(1000);

        // 2. Create Thread Pool
        ExecutorService executor =
                Executors.newFixedThreadPool(5);


        // 3. Deposit Operations
        for (int i = 1; i <= 5; i++) {

            executor.execute(() -> {

                account.deposit(100);

                System.out.println(
                        Thread.currentThread().getName()
                        + " deposited 100"
                );

            });

        }


        // 4. Withdrawal Operations
        for (int i = 1; i <= 5; i++) {

            executor.execute(() -> {

                boolean success = account.withdraw(50);

                if (success) {

                    System.out.println(
                            Thread.currentThread().getName()
                            + " withdrew 50"
                    );

                } else {

                    System.out.println(
                            Thread.currentThread().getName()
                            + " withdrawal failed"
                    );

                }

            });

        }


        // 5. Shutdown Executor
        executor.shutdown();


        // 6. Wait for all tasks
        try {

            boolean finished = executor.awaitTermination(
                    30,
                    TimeUnit.SECONDS
            );

            if (!finished) {

                executor.shutdownNow();

                System.out.println("Tasks did not finish in time");
                return;

            }

        } catch (InterruptedException e) {

            executor.shutdownNow();

            Thread.currentThread().interrupt();

            return;
        }


        // 7. Test insufficient balance
        boolean result = account.withdraw(2000);

        System.out.println(
                "\nWithdraw 2000: "
                + (result ? "Success" : "Failed")
        );


        // 8. Print final balance
        System.out.println(
                "Final Balance: " + account.getBalance()
        );

    }
}
