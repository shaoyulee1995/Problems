# Print in Order

# Solution 1

- Time Complexity: O(1)
- Space Complexity: O(1)

```
class Foo {
    Semaphore run2, run3;
    public Foo() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        run3.release();
    }
    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
```

# Solution 2

- Time Complexity: O(1)
- Space Complexity: O(1)

```
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
```
