package test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureTest {
	private String s = "";

	public static void main(String[] s) {
		new FutureTest();
	}

	private FutureTest() {
		case3();
		
	}

	private void case1() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			s += "QQ";
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			return s;
		});
		
		System.out.println("A");

		try {
			// call get will lock main thread
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private void case2() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			s += "QQ";
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			return s;
		});
		
		System.out.println("A");
		System.out.println(future.complete("ABC"));
		try {
			// future直接以ABC當成結果
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("B");
	}
	
	private void case3() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			s += "QQ";
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			return s;
		});
		
		future.completeExceptionally(new Exception("GG"));
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
