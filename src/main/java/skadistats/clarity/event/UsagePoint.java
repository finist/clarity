package skadistats.clarity.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class UsagePoint<A extends Annotation> {

    protected final Logger log;

    protected final A annotation;
    protected final Class<?> processorClass;
    protected final Method method;
    protected final UsagePointMarker usagePointMarker;

    public UsagePoint(A annotation, Class<?> processorClass, Method method, UsagePointMarker usagePointMarker) {
        this.log = LoggerFactory.getLogger(getClass());
        this.annotation = annotation;
        this.processorClass = processorClass;
        this.method = method;
        this.usagePointMarker = usagePointMarker;
    }

    public A getAnnotation() {
        return annotation;
    }

    public Class<?> getProcessorClass() {
        return processorClass;
    }

    public Method getMethod() {
        return method;
    }

    public Class<? extends Annotation> getUsagePointClass() {
        return annotation.annotationType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsagePoint that = (UsagePoint) o;

        if (!annotation.equals(that.annotation)) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        if (!processorClass.equals(that.processorClass)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = annotation.hashCode();
        result = 31 * result + processorClass.hashCode();
        result = 31 * result + (method != null ? method.hashCode() : 0);
        return result;
    }

}
