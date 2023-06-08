package com.zenika.training.bc_alerting.domain;



public record CodePostal(String code) {

   public CodePostal {
       if(code.length() <5)
       {
           throw new CodePostalMalmorfedException("Failed");
       }
   }

}
