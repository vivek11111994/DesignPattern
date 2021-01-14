interface Gun {
        String shoot ();
}

public class DecoratorPattern {
        public static void main (String[] args) {
                Gun gun = new ExtendedMag (new Scope (new Scarl ()));

                System.out.println (gun.shoot ());
        }
}

class Scarl implements Gun {

        public String shoot () {
                return "Shooting scarl";
        }
}

abstract class Addons implements Gun {
        private final Gun gun;

        public Addons (Gun gun) {
                this.gun = gun;
        }

        public String shoot () {
                return gun.shoot ();
        }
}

class Scope extends Addons {
        public Scope (Gun gun) {
                super (gun);
        }

        public String shoot () {
                return super.shoot () + " with Scope";
        }
}

class ExtendedMag extends Addons {
        public ExtendedMag (Gun gun) {
                super (gun);
        }

        public String shoot () {
                return super.shoot () + " with extended mag";
        }
}