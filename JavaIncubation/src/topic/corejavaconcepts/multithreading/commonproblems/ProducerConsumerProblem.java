package topic.corejavaconcepts.multithreading.commonproblems;

public class ProducerConsumerProblem {

    public static void main(String[] args) {

        Product product = new Product(0,true);
        ProducerConsumer producerConsumer = new ProducerConsumer();


        Thread t1 = new Thread(new ProducerThread(producerConsumer,product,10));
        Thread t2 = new Thread(new ConsumerThread(producerConsumer,product,10));

        t1.start();
        t2.start();

    }

}



class ProducerThread implements Runnable{

    private ProducerConsumer producerConsumer;
    private Product product;
    private int maxQuantity;

    public ProducerThread(ProducerConsumer producerConsumer, Product product, int maxQuantity){
        this.producerConsumer = producerConsumer;
        this.product = product;
        this.maxQuantity = maxQuantity;

    }

    @Override
    public void run() {
        while (true){
            product.setQuantity(product.getQuantity()+1);
            producerConsumer.produce(product);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ConsumerThread implements Runnable{
    private ProducerConsumer producerConsumer;
    private Product product;
    private int maxQuantity;

    public ConsumerThread(ProducerConsumer producerConsumer, Product product, int maxQuantity){
        this.producerConsumer = producerConsumer;
        this.product = product;
        this.maxQuantity = maxQuantity;

    }

    @Override
    public void run() {
        while (true){
            producerConsumer.consume(product);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }}

class ProducerConsumer{

    public synchronized void produce(Product product){
        while(!product.isProducing()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Producer Produce:"+product.getQuantity());
        product.setProducing(false);
        product.setQuantity(product.getQuantity());
        notify();
    }
    public synchronized void consume(Product product){

        while(product.isProducing()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumer Consume:"+product.getQuantity());
        product.setProducing(true);
        notify();
    }
}




class Product{
    private int quantity;
    private boolean producing;

    public Product(int quantity, boolean producing) {
        this.quantity = quantity;
        this.producing = producing;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isProducing() {
        return producing;
    }

    public void setProducing(boolean producing) {
        this.producing = producing;
    }

}