package com.xwl.shared.library;



import android.app.Application;
import android.content.Context;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/7/19 14:07
 */
public class SharedTest {
    /**
     * 默认SP
     */
    private SharedManager mSharedManager;
    /**
     * 自定义用户标识SP
     */
    private SharedManager specificFlag;
    /**
     * 自定义文件名SP
     */
    private SharedManager specificFileName;
    /**
     * 打开版本控制SP
     */
    private SharedManager specificVersionControl;

    @Before
    public void setUp() throws Exception {
        Context app = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
        Shared.initEncryptionKey(app, "@#$$ZSW^^^&&**%%^&****>>>>");

        mSharedManager = Shared.with(app);

        SharedConfig mSharedConfigFlag = SharedConfig.builder().setShareFlag("15610001000").build();
        specificFlag = Shared.with(app, mSharedConfigFlag);

        SharedConfig mSharedConfigFileName = SharedConfig.builder().setShareFileName("UserInfo").build();
        specificFileName = Shared.with(app, mSharedConfigFileName);

        SharedConfig mSharedConfigVersion = SharedConfig.builder().setVersionControl(true).build();
        specificVersionControl = Shared.with(app, mSharedConfigVersion);
    }

    @Test
    public void testSharedManager() {
        testStorage(mSharedManager);
    }

    @Test
    public void testSharedManagerFlag() {
        testStorage(specificFlag);
    }

    @Test
    public void testSharedManagerFileName() {
        testStorage(specificFileName);
    }

    @Test
    public void testSharedManagerVersion() {
        testStorage(specificVersionControl);
    }

    private void testStorage(SharedManager mTestSM) {
        mTestSM.putBoolean("testBoolean", true);
        Assert.assertTrue(mTestSM.getBoolean("testBoolean", false));

        mTestSM.putBoolean("testBoolean", false);
        Assert.assertFalse(mTestSM.getBoolean("testBoolean", true));

        mTestSM.putInt("testInt", 19);
        Assert.assertEquals(mTestSM.getInt("testInt", 0), 19);

        mTestSM.putInt("testInt", -99);
        Assert.assertEquals(mTestSM.getInt("testInt", 0), -99);

        mTestSM.putInt("testInt", Integer.MAX_VALUE);
        Assert.assertEquals(mTestSM.getInt("testInt", 0), Integer.MAX_VALUE);

        mTestSM.putInt("testInt", Integer.MIN_VALUE);
        Assert.assertEquals(mTestSM.getInt("testInt", 0), Integer.MIN_VALUE);

        mTestSM.putString("testString", "测试");
        Assert.assertEquals(mTestSM.getString("testString", ""), "测试");

        mTestSM.putString("testString", "");
        Assert.assertEquals(mTestSM.getString("testString", ""), "");

        mTestSM.putString("testString", null);
        Assert.assertEquals(mTestSM.getString("testString", ""), "");

        mTestSM.putLong("testLong", 81L);
        Assert.assertEquals(mTestSM.getLong("testLong", 0), 81L);

        mTestSM.putLong("testLong", -16L);
        Assert.assertEquals(mTestSM.getLong("testLong", 0), -16L);

        mTestSM.putLong("testLong", Long.MAX_VALUE);
        Assert.assertEquals(mTestSM.getLong("testLong", 0), Long.MAX_VALUE);

        mTestSM.putLong("testLong", Long.MIN_VALUE);
        Assert.assertEquals(mTestSM.getLong("testLong", 0), Long.MIN_VALUE);

        mTestSM.putFloat("testFloat", 3.16f);
        Assert.assertEquals(mTestSM.getFloat("testFloat", 0), 3.16f);

        mTestSM.putFloat("testFloat", 0.015f);
        Assert.assertEquals(mTestSM.getFloat("testFloat", 0), 0.015f);

        mTestSM.putFloat("testFloat", Float.MAX_VALUE);
        Assert.assertEquals(mTestSM.getFloat("testFloat", 0), Float.MAX_VALUE);

        mTestSM.putFloat("testFloat", Float.MIN_VALUE);
        Assert.assertEquals(mTestSM.getFloat("testFloat", 0), Float.MIN_VALUE);

        mTestSM.putDouble("testDouble", 2.63d);
        Assert.assertEquals(mTestSM.getDouble("testDouble", 0), 2.63d);

        mTestSM.putDouble("testDouble", -9.47d);
        Assert.assertEquals(mTestSM.getDouble("testDouble", 0), -9.47d);

        mTestSM.putDouble("testDouble", Double.MAX_VALUE);
        Assert.assertEquals(mTestSM.getDouble("testDouble", 0), Double.MAX_VALUE);

        mTestSM.putDouble("testDouble", Double.MIN_VALUE);
        Assert.assertEquals(mTestSM.getDouble("testDouble", 0), Double.MIN_VALUE);
    }
}