package topic.designpattern.structural.adapter;

/**
 *  Adapter to make LegacySystem work with NewSystemInterface
 */
public class Adapter implements NewSystemInterface{

    private final LegacySystem legacySystem;

    public Adapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void newMethod() {
        legacySystem.oldMethod();
    }
}
