# Java Stream

## Stream之collect

> collect的作用就是可以把流转化为我们想要的格式

### toList

> 将流中的数据转化为list集合

```java
package com.zqh;

import com.zqh.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/4/5 16:08
 */
public class StreamTest {

    @Test
    public void toList() {
        String[] arr = new String[]{"11", "22", "33", "44", "55"};
        List<String> list = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(list);
    }

}
```

输出结果为:

> [11, 22, 33, 44, 55]

我们可以看到一个数组被转化成了List集合

### toSet

> set集合和list同理

```java
package com.zqh;

import com.zqh.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2021/4/5 16:08
 */
public class StreamTest {

    @Test
    public void toList() {
        String[] arr = new String[]{"11", "22", "33", "44", "55", "33"};
        Set<String> list = Arrays.stream(arr).collect(Collectors.toSet());
        System.out.println(list);
    }

}
```

输出结果为:

> [11, 22, 33, 44, 55]

重复的33被覆盖了

