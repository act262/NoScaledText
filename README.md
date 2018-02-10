### 修改系统字体大小会导致App的字号跟随变化，如果适配没做好的情况下字号大小变化会导致UI变形


### 使用
```java
NoScaledUtils.setDefaultDisplay(context);
```

1. 基类这里重写显示配置
```java
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NoScaledUtils.setDefaultDisplay(this);       
    }
```

2. 如果manifest中配置了 configChanges ，Activity没有重启的情况下需要手动设置下更新显示配置
```java
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        NoScaledUtils.setDefaultDisplay(this);
    }
```


### WHY影响字体大小
参考Resource（ResourceImpl）、Configuration、TypedValue代码
```java
    public static float applyDimension(int unit, float value,
                                       DisplayMetrics metrics)
    {
        switch (unit) {
        case COMPLEX_UNIT_PX:
            return value;
        case COMPLEX_UNIT_DIP:
            return value * metrics.density;
        case COMPLEX_UNIT_SP:
            return value * metrics.scaledDensity;
        case COMPLEX_UNIT_PT:
            return value * metrics.xdpi * (1.0f/72);
        case COMPLEX_UNIT_IN:
            return value * metrics.xdpi;
        case COMPLEX_UNIT_MM:
            return value * metrics.xdpi * (1.0f/25.4f);
        }
        return 0;
    }
```
可见字号大小由fontScale、scaledDensity、density决定，所以控制fontScale、scaledDensity不变即可。