package com.snailjw.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射相关方法
 *
 * @author : snail
 * @date : 2021-12-04 19:58
 **/
public class ReflectionTest {
    public static void main(String[] args) {
        String name ;
        Scanner scanner = new Scanner(System.in);
        if (args.length>0 ){
            name = args[0];
        }else {
            name = scanner.next();
        }

        try {
            Class clazz = Class.forName(name);
            Class superclass = clazz.getSuperclass();
            int modifiers = clazz.getModifiers();
            String s = Modifier.toString(modifiers);
            if (s.length()>0){
                System.out.print(s+" ");
            }
            System.out.print("class  " + name);
            if (superclass != null && superclass != Object.class){
                System.out.print(" extend "+ superclass.getName());
            }
            System.out.println(" {\n");
            printConstructors(clazz);
            System.out.println();
            printMethods(clazz);
            System.out.println();
            printFields(clazz);
            System.out.println(" \n}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printFields(Class clazz) {
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String s = Modifier.toString(field.getModifiers());
            if (s.length()>0){
                System.out.print("  "+s);
            }
            System.out.print(" "+fieldName+" ;");
            System.out.println();
        }
    }

    private static void printMethods(Class clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            String s = Modifier.toString(method.getModifiers());
            if (s.length()>0){
                System.out.print("  "+ s +" " );

            }
            System.out.print(method.getReturnType().getSimpleName()+" ");
            System.out.print(methodName+ " ( ");
            Class[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                String name = parameterTypes[i].getName();
                if (i>0){
                    System.out.print(", ");
                }
                System.out.print(name);
            }
            System.out.println(" );");
        }
    }

    private static void printConstructors(Class clazz) {
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            String constructorName = constructor.getName();
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length()>0){
                System.out.print("  "+ modifiers+" ");
            }
            System.out.print(constructorName+" (");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0){
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getSimpleName());
            }
            System.out.println(");");
        }
    }
}
