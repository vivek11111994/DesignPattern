// The builder pattern provides a build object which is used to construct a complex object called the product. It
// encapsulates the logic of constructing the different pieces of the product.

public class BuilderPattern {
        public static void main (String[] args) {
                Student student = new Builder ()
                        .setId (1)
                        .setName ("Vivek")
                        .setAddress ("Kanpur")
                        .build ();

                System.out.println (student.toString ());
        }
}

class Student {
        private final int id;
        private final String name;
        private final String address;

        public Student (Builder builder) {
                this.id = builder.getId ();
                this.name = builder.getName ();
                this.address = builder.getAddress ();
        }

        @Override
        public String toString () {
                return "id = " + this.id + ", name = " + this.name +
                        ", address = " + this.address;
        }
}

class Builder {
        private int id;
        private String name = "";
        private String address = "";

        public Builder () {}

        public int getId () {
                return id;
        }

        public Builder setId (int id) {
                this.id = id;
                return this;
        }

        public String getName () {
                return name;
        }

        public Builder setName (String name) {
                this.name = name;
                return this;
        }

        public String getAddress () {
                return address;
        }

        public Builder setAddress (String address) {
                this.address = address;
                return this;
        }

        public Student build () {
                return new Student (this);
        }
}