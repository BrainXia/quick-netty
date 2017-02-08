import junit.framework.Assert;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MsgPackTest
 *
 * @author Xia Dong
 * @date 2017/2/7
 */
public class MsgPackTest {
    @Test
    public void testMsgPack() throws Exception {
        List<String> src = new ArrayList<String>();
        src.add("123");
        src.add("456");
        src.add("678");

        MessagePack msgpack = new MessagePack();
        byte[] raw = msgpack.write(src);

        List<String> des = msgpack.read(raw, Templates.tList(Templates.TString));

        Assert.assertEquals(des.size(),3);
        Assert.assertEquals(des.get(0),"123");
        Assert.assertEquals(des.get(1),"456");
        Assert.assertEquals(des.get(2),"678");
    }
}
