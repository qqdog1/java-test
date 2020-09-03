package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ForEachTest {
	public static void main(String[] s) {
		new ForEachTest();
	}
	
	private ForEachTest() {
		String[] names = new String[] {"abc", "123"};
		
		Arrays.asList(names).stream().map(Name::new).collect(Collectors.toList()).forEach(a -> {
			System.out.println(a.getName());
		});
//		
//		
//		Arrays.asList(notification.getGroupNotifications()).stream().map(APIWebNotificationV2::new).collect(Collectors.toList()).forEach(apiWebNotification -> {
//            WebSocketService.INSTANCE.sendMessageByUser(WebSocketArgEnum.SUBSCRIBE.name(), notification.getUsername(), WebSocketTopicEnum.NOTIFICATIONAPIV2, null, apiWebNotification, null);
//        });

	}
	
	public class Name {
		private String name;
		
		public Name(String n) {
			this.name = n;
		}
		
		public String getName() {
			return name;
		}
	}
}
