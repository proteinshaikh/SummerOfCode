package Summer2023.a.interfaces;

interface Run {
    void doRun();
}

interface Fly {
    void doFly();
}

interface Swim {
    void doSwim();
}

public class Animal implements Run, Fly, Swim {
    @Override
    public void doRun() {
        // Implement the method
    }

    @Override
    public void doFly() {
        // Implement the method
    }

    @Override
    public void doSwim() {
        // Implement the method
    }
}

/*
* if you want to prevent doRun and doSwim methods from being accessed in the Bird class, here are a few approaches:
* Override and throw exceptions: This method explicitly makes those functions unusable.
* */
class Bird extends Animal {
    @Override
    public void doRun() {
        throw new UnsupportedOperationException("Birds do not run in this context.");
    }

    @Override
    public void doSwim() {
        throw new UnsupportedOperationException("Birds do not swim in this context.");
    }
}


