package com.bk.secureapi.component;

import com.bk.api.exceptions.CustomAccessDeniedException;
import com.bk.secureapi.model.Forbidden;
import com.bk.secureapi.services.ForbiddenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

@Component
public class CheckACL {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    @Autowired
    ForbiddenService forbiddenService;

    public void checkAccess( final String endpoint, final String staffRole, final String customerRole, final String param) {
        String key=endpoint+"_"+param+"-"+staffRole.replaceAll("_","")+"-"+customerRole.replaceAll("_","");
        String keySlug = toSlug(key);
        Forbidden endpoint2 = forbiddenService.findById(key);
        System.out.println(keySlug);
        if (endpoint2 != null) {
            throw new CustomAccessDeniedException("Forbidden you don't have permission to access this service, "+key+","+keySlug);
        }
    }


    public String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
