class Foo {

    int cnt;
    public Foo() {
        cnt = 0;
    }

    public void first(Runnable print) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        this.waitCountThenRun(0,print);
    }

    public void second(Runnable print) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        this.waitCountThenRun(1,print);
    }

    public void third(Runnable print) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        this.waitCountThenRun(2,print);
    }
    private synchronized void waitCountThenRun(int i, Runnable print) throws InterruptedException {
        while(i!=this.cnt){
            this.wait();
        }
        print.run();
        this.cnt++;
        notifyAll();
    }
}