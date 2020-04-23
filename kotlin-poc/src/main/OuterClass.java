package main;

public class OuterClass {

    private String name;
    private String age;

    void doCalculation() {
        System.out.println("calculating.....");


    }

    static void ableToBeInInner() {
        System.out.println("called from static");
        String testString = "wow";

        class localClass {
            String jwow = "ww";
            String someything = "test";

            public void invoke() {
                System.out.println(testString);
            }
        }

        localClass localClass = new localClass();
        System.out.println(localClass.jwow);
    }

    public class nestedClass {
        public int beers;
        public int cookies;

        void method() {

            System.out.println("cant have static.....");
        }
    }

    public static class nestedStaticClass {
        private String story;
        public int beers;
        public static int cookies;

        private static void drink() {
            ableToBeInInner();
        }

        void test() {
            System.out.println("non static member");
        }

        /**
         * AVOID TOO MANY NEST INNER CLASSES
         */
        public static class innerInnerClass {
            private String story;
            public int beers;

            private static void drink() {
                ableToBeInInner();
            }

            void test() {
                System.out.println("non static member");
            }
        }
    }
}
