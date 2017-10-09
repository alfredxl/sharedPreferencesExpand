sharedPreferencesExpand<br>
==
友好的本地SP文件常用存储功能的封装插件。<br>

插件介绍：
--
1、本插件底层采用字符串存储(所有基本类型都会转换成String类型存储)，存储的值经过3DES加密。<br>
2、本插件封装了常见的对不同用户数据分组的功能。（默认不分组）<br>
3、本插件封装了对版本升级，数据不兼容情况下的数据清理功能（默认关闭）<br>

使用说明:
--
a、导入本插件：
>在项目目录的gradle文件中添加如下地址:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
>在Module的gradle文件夹中加入:
```groovy
dependencies {
    ...
    compile 'com.github.alfredxl:sharedPreferencesExpand:v1.0.0'
}
```

b、基本使用:
>在使用之前需要初始化密钥，用来对数据加密，一般在application中初始化:
```java
Shared.initEncryptionKey(context, "@#$$ZSW^^^&&**%%^&****>>>>");
```

>初始化后，即可使用：
```java
// 存数据
Shared.with(context).putString("test", "value");
// 取数据
Shared.with(context).getString("test", "defaultValue");
```
>注意：上述默认使用，不会对数据做不同用户、不同版本的区分！


c、自定义配置用法（不对默认存储产生影响）
>本插件提供了SharedConfig构建类，用于定制存储方案，具体使用如下:
```java
SharedConfig config = SharedConfig.builder()
                .setShareFileName("TestSp") //配置SP文件的名称
                .setShareFlag("001") //配置用户区分标记
                .setVersionControl(true) //配置是否开启版本控制
                .build(); //构建配置清单
        
Shared.with(context, config).putString("test", "value");
```
>具体配置说明如下:<br>
>ShareFileName：文件名称，也就是SP文件的实际名称<br>
>ShareFlag: 用来对不同用户做区分，可保存多个不同用户的数据（即相同的key,对应不同的用户的数据）<br>
>VersionControl: 是否对数据的版本做控制，默认为false, 如果开启，则APP版本发生变化，获取到的数据将为空（在新版本执行数据插入之前）, 版本控制只保存最新版本的数据，旧版本的数据将被覆盖<br>
>注意：以上配置只针对SP文件中当前key有效


d、关于清除数据
>1、清除默认SP文件的数据（整个默认SP文件的数据都会被清除）:
```java
Shared.clear(context);
```
>2、清除指定SP文件的数据（改指定文件的数据都会被清除）:
```java
SharedConfig config = SharedConfig.builder()
                .setShareFileName("TestSp") //只需要指定SP文件名即可
                .build(); //构建
Shared.clear(context, config);
```


e、底层数据结构如下:
```java
<string name = "testKey">{ "用户001": { "001版本": "testValue" } ,"用户002": { "001版本": "testValue" } }</string>
```


关于混淆:
--
本插件可以完全混淆，不需要keep


欢迎留言和star
---

邮箱地址:32038305@qq.com
