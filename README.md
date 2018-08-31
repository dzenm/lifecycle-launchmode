## 一、Android生命周期

<br />

### 1. android生命周期整个过程

<br />

* 英文

    ![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/activitystart_en.png)
    
<br />

* 中文
    
    ![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/activitystart_zh.png)
    
<br />

* Activity 进栈和出栈方式
    
    ![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/activitystackinandout.png)
    
<br />
    
* Activity 栈内结构
    
    ![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/activitystacksave.png)
    
<br />
    
* Activity 运行实例
    
    ![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/activitystackrun.png)
    
<br /><br />

### 2. android生命周期的生存期

<br />

* 完整生存期：Activity从创建Activity( onCreate() ) 到销毁Activity( onDestory() )所经历的时期
* 可见生存期：Activity在 onStart() 方法中开始可见，但不能与用户进行交互，在 onStop() 方法中变为不可见。如果Activity 没有重新创建，它会调用 onRestart() 方法。
* 前台生存期：Activity处于允许状态，它可以与用户进行交互，它会调用 onResume() 方法，与之对应的为 onPause() 方法。
    
<br /><br />

### 3. android生命周期的调用方法

<br />

&nmsp;&nmsp;创建一个新的Activity：
> onCreate() -> onStart() -> onResume()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/createtop.png)
    
<br />
    
&nmsp;&nmsp;从一个Activity跳转到新的Activity，它先调用的是当前的Activity的onPause()，先停止当前当前的Activity的操作，再创建新的Activity，等创建完新的Activity再将原Activity变为不可见：
> onPause() -> onCreate() -> onStart() -> onResume() -> onStop() 
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/startnewactivity.png)
    
<br />
    
&nmsp;&nmsp;如果按返回键退回到上一个Activity：
> onPause() -> onRestart() -> onStart() -> onResume() -> onStop() -> onDestory()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/backlastactivity.png)
    
<br />

&nmsp;&nmsp;打开一个透明主题的Activity
> onPause() -> onCreate() -> onStart() -> onResume()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/startthemeactivity.png)
    
<br />
    
&nmsp;&nmsp;从透明主题的Activity返回到之前的Activity
> onPause() -> onResume() -> onStop() -> onDestory()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/backthemeactivity.png)
    
<br />
    
&nmsp;&nmsp;锁屏：
> onPause() -> onStop()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/lockscreen.png)
    
<br />
    
&nmsp;&nmsp;解锁:
> onRestart() -> onStart() -> onResume()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/unlockscreen.png)
    
<br />
    
&nmsp;&nmsp;按HOME键退回到主页面
> onPause() -> onStop()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/backhome.png)
    
<br />
    
&nmsp;&nmsp;从主页面回到应用程序
> onRestart() -> onStart() -> onResume()
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/backactivity.png)
    
<br /><br />

### 二、Activity的启动模式

<br />

1. 给Activity指定启动模式：通过Intent标志位启动Activity比添加属性launchMode优先级高，两种情况同时存在时，按照Intent标志位启动。Intent无法添加singleInstance启动模式，launchMode无法添加属性FLAG_ACTIVITY_CLEAR_TOP。
    * 通过AndroidManifest中在activity下添加属性launchMode
    * 通过Intent添加标志位启动

<br />

2. singleTop：栈顶复用模式，如果Activity设置为singleTop的启动模式，并且该Activity处于栈顶，那么将不会创建一个新的Activity实例，它会复用当前Activity，并且会调用 onNewIntent() 方法，Activity启动时Intent添加flag指定为FLAG_ACTIVITY_NEW_TASK和指定为singleTop启动一样的效果。例如ABCD四个Activity顺序排列，D处于栈顶，在D里启动D，顺序为ABCD，不会再创建新的D，如果是standard启动模式，则会创建新的实例，顺序将变为ABCDD。

![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/singletopphoto.jpg)
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/singletoplog.png)

<br />

3. singleTask：栈内复用模式，这是一种单实例模式。被启动的Activity指定为singleTask模式，如果当前栈内存在该Activity的实例，就不会创建新的Activity实例，会将栈内存在的Activity实例推向栈顶并调用 onNewIntent() 方法，并且在该实例之上的Activity实例推出栈外。例如ADBC，D被指定为singleTask，启动之后的顺序为AD，BC被推出栈，singleTask具有cleanTop的效果。

![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/singletask.gif)
    
<br />

4. singleInstance：单实例模式，这是一种加强版的singleTask模式，它具有singleTask的所有特性，同样的，它也会调用 onNewIntent() 方法。 除此之外，它可以把设置为singleInstance的Activity放在一个单独的任务栈，由于栈内复用的特性后续请求不会再创建新的实例，除非该栈被销毁。
    
![image](https://github.com/freedomeden/LifeCycleAndLaunchMode/blob/master/picture/singleinstance.gif)
    
<br /><br />
