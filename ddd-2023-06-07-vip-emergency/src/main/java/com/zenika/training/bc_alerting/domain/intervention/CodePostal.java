package com.zenika.training.bc_alerting.domain.intervention;


import com.zenika.training.bc_alerting.domain.intervention.exceptions.CodePostalMalmorfedException;

public record CodePostal(String code) {

   public CodePostal {
       if(code.length() <5)
       {
           throw new CodePostalMalmorfedException("Failed");
       }
   }

}
