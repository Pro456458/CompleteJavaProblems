package topic.designpattern.structural.adapter;

/**
 * Example : Adapting a legacy system to a modern system <br>
 *
 * Imagine you have a system that needs to interact with a<br>
 * third-party library (legacy system), but the legacy system's interface<br>
 * is incompatible with your current code. You can use an adapter to convert the <br>
 * legacy interface to one that is expected by your system.<br><br>
 *
 *  Problem:<br>
 *  Let’s say you have a legacy system that outputs information in a<br>
 *  different format than your new system expects.<br><br>
 *
 *  Explanation:<br>
 * - The LegacySystem class has an outdated interface.<br>
 * - The NewSystemInterface defines the method expected by the new system.<br>
 * - The Adapter class allows the old method (oldMethod()) to be used as if it were newMethod() via delegation.<br>
 */
public class AdapterPatternExample {
    public static void main(String[] args) {

        LegacySystem legacySystem = new LegacySystem();
        NewSystemInterface adaptedSystem = new Adapter(legacySystem);
        adaptedSystem.newMethod(); //This works because of the adapter
    }

}
