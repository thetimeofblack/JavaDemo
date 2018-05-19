package coreJava.streamAndLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Transaction {

    //unit test
    public static void main(String[] args) {
        Transaction s1 = new Transaction(1,Transaction.GROCERY,300);
        Transaction s2 = new Transaction(2,Transaction.CANDY,200);
        Transaction s3 = new Transaction(3,Transaction.GROCERY,100);
        Transaction s4 = new Transaction(4,Transaction.CANDY,400);
        Transaction s5 = new Transaction(5,Transaction.GROCERY,500);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(s1);transactions.add(s2);transactions.add(s3);transactions.add(s4);transactions.add(s5);
        /**
         * 如果要发现 type 为 grocery 的所有交易，然后返回以交易值降序排序好的交易 ID 集合
         * before Java 8 */
        List<Transaction> groceryInstances = new ArrayList<>();
        for(Transaction transaction:transactions){
            if(transaction.getType() == Transaction.GROCERY){
                groceryInstances.add(transaction);
            }
        }
        Collections.sort(groceryInstances, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t1.getValue() - t2.getValue();
            }
        });
        for(Transaction groceryInstance:groceryInstances){
            System.out.printf("%d ",groceryInstance.getId());
        }

        /**now we do that in Java 8 -> both efficient and readable*/
        List<Integer> transactionIDs = transactions.stream()
                .filter(t -> t.getType() == Transaction.GROCERY)
                .sorted(Comparator.comparingInt(t -> t.getValue())).map(Transaction::getId)
                .collect(Collectors.toList());
    }

    public static final int GROCERY = 1;
    public static final int CANDY = 2;

    private int id;
    private int type;
    private int value = 0;

    public Transaction(int id, int type, int value){
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
