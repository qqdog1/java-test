package test.jmx.metrics;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class MetricsTest {
	static final MetricRegistry metrics = new MetricRegistry();

	public static void main(String[] args) {
		new MetricsTest();
	}

	private MetricsTest() {
		System.out.println(metrics.name(String.class, "aaaaaa", null));
		
		startReport();
		Meter requests = metrics.meter("requests");
		requests.mark();
		wait5Seconds();
	}

	static void startReport() {
		ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
				.convertRatesTo(TimeUnit.SECONDS)
				.convertDurationsTo(TimeUnit.MILLISECONDS).build();
		
		final JmxReporter jmxReporter = JmxReporter.forRegistry(metrics).build();
		
		jmxReporter.start();
		
//		reporter.start(1, TimeUnit.SECONDS);
	}

	static void wait5Seconds() {
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
		}
	}
}
