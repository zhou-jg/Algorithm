package basic.string.application;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/27.
 */
public class PathSimplifierTest {
    PathSimplifier p = new PathSimplifier();

    @Test
    public void test(){
        assertEquals("/home", p.simplifyPath("/home/"));
        assertEquals("/c", p.simplifyPath("/a/./b/../../c/"));
        assertEquals("/", p.simplifyPath("/../"));
        assertEquals("/home/foo", p.simplifyPath("/home//foo/"));
    }
}