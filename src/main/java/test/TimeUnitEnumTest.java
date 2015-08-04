package test;

public enum TimeUnitEnumTest {
	NANOSECONDS {
        @Override
        public long toNanos(long d) {
            return d *5;
        }

    },
    MICROSECONDS {

    },
    MILLISECONDS {

    },
    SECONDS {

    },
    MINUTES {

    },
    HOURS {

    },
    DAYS {

    };

    public long toNanos(long duration) {
        return duration;
    }
}
