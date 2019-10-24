package temaMak.counters.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import temaMak.counters.converter.CounterActionConverter;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService f = super.mvcConversionService();
        f.addConverter(new CounterActionConverter());
        return f;
    }

}
