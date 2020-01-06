package beans;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		Class<?> clz = Class.forName("beans.SampleVO");
		
		System.out.println(clz);
		
		BeanInfo info = Introspector.getBeanInfo(clz);		
		
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		
		System.out.println(Arrays.toString(props));
		
		//Object obj = clz.newInstance(); /java 1.6에선 사용가능했었음
		
		Constructor<?> con = clz.getConstructor(null);
		
		Object obj = con.newInstance(null);
		
		System.out.println(obj);
		
		for (PropertyDescriptor prop : props) { //향상된 for문
			
			Method method = prop.getWriteMethod();
			if(method != null) {
				method.invoke(obj, "AAA");
			}
		}
		System.out.println(obj);
	}
}
