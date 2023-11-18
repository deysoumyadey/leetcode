package Experiment.CustomRetry;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodPoller<T, R> {

    private Supplier<T> pollSupplierMethod = null;
    private Function<T, R> pollFunctionMethod = null;
    private Predicate<T> pollResultPredicate = null;

    public MethodPoller() {
    }

    public MethodPoller<T, R> poll(){
        return this;
    }

    public MethodPoller<T, R> method(Supplier<T> supplier) {
        pollSupplierMethod = supplier;
        return this;
    }

    public MethodPoller<T, R> method(Function<T, R> function) {
        pollFunctionMethod = function;
        return this;
    }

    public MethodPoller<T, R> until(Predicate<T> predicate) {
        pollResultPredicate = predicate;
        return this;
    }

    public T executeSupplier() {
        T result = null;
        boolean pollSucceeded = false;

        while (!pollSucceeded) {
            result = pollSupplierMethod.get();
            pollSucceeded = pollResultPredicate.test(result);
        }
        return result;
    }

    /*public R executeFunction() {
        R result = null;
        boolean pollSucceeded = false;

        while (!pollSucceeded) {
            result = pollFunctionMethod.apply(T);
            pollSucceeded = pollResultPredicate.test(result);
        }
        return result;
    }*/
}
