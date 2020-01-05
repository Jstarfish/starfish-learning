package annotatin;

import java.lang.annotation.Repeatable;

@Repeatable(Authors.class)
public @interface Author {

    String name();
}
