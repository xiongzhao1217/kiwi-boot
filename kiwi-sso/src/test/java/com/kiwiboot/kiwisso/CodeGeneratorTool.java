package com.kiwiboot.kiwisso;

import com.kiwiframework.generator.CodeGenerator;

public class CodeGeneratorTool {

    public static void main(String[] args) {
//        CodeGenerator.genCode("sso_apps", "Apps");
//        CodeGenerator.genCode("a_role", "Role");
//        CodeGenerator.genCode("a_menu", "Menu");
//        CodeGenerator.genCode("sso_user", "User");
//        CodeGenerator.genCode("a_role_menu_rela", "RoleMenuRela");
//        CodeGenerator.genCode("a_role_user_rela", "RoleUserRela");
        CodeGenerator.genCode("a_access", "Access");
        CodeGenerator.genCode("a_role_access_rela", "RoleAccessRela");
    }
}
