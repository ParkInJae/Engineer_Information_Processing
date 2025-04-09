# 해당 코드에서 발생한 에러 내용 

<h3>1 컴파일 에러 발생 </h3>

```
// 에러 내용 
Exception in thread "main" java.lang.NoSuchMethodError: ChildClass.<init>(I)V  
        at This_Super.main(This_Super.java:55)
```

위의 내용은 컴파일 관련 에러 내용이다. 

즉, JVM이 실행 중에 특정 메서드(또는 생성자)를 찾지 못했을 때 발생하는 런타임 오류이며, This_Super.java에서 매개변수가 존재하는 생성자를 찾지 못햇을 때 발생한다. 

<h3>2 인코딩 에러 </h3>

```
// 에러 내용 
This_Super.java:29: error: unmappable character (0xED) for encoding x-windows-949
This_Super.java:30: error: unmappable character (0xEC) for encoding x-windows-949

```

위의 내용은 인코딩이 되지 않아서 발생한 에러이며, TERMINAL에서 글자가 깨진것을 확인할 수 있다. 


```
// 작성할 내용 
javac -encoding UTF-8 This_Super.java
```

위의 코드를 통해서 컴파일 하면된다. 


<h3>3. 인코딩 수정 </h3>

.vscode의 setting.json의 내용을 수정하여 기본 encoding을 수정했다. 

```
// 작성할 내용 
    "files.encoding": "utf8" // 해당 클래스의 기본 인코딩 설정 
```

<h3>4. 현재 디렉토리를 classpath에 포함하기  </h3>

인코딩 설정 후 ClassNotFoundException이 발생했다. 

'''
// 에러 내용
Error: Could not find or load main class This_Super  
Caused by: java.lang.ClassNotFoundException: This_Super
'''




```  
// 작성할 내용 
java -cp . This_Super
```

-cp . : 현재 **디렉토리(.)** 를 자바의 **클래스 경로(classpath)** 로 지정하겠다는 뜻.
cp => classpath의 줄임말 

This_Super : This_Super.class 파일에서 main() 메서드를 찾아 실행한다는 의미.

즉, 현재 디렉토리에서 This_Super의 메인 클래스를 찾아서 실행하겠다는 의미.

```
// 그림
📂 this_method\src  
├── This_Super.java
├── This_Super.class   ← 실행할 클래스

```


**디렉토리(.)**
프로젝트를 구성하는 폴더 구조  // 위의 예시의 경우에는 .java와 .class가 모여있는 src가 디렉토리이다.

예시:
This_Super.java는 프로젝트 안에 있는 **파일(클래스)**이고,
This_Super.class는 그걸 컴파일한 **실행 가능한 클래스 파일**.


**클래스 경로(classpath)**

**클래스패스(classpath)**는 Java가 .class 파일을 찾을 때 "어디에서 찾을지" 알려주는 경로 설정




<hr>

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


