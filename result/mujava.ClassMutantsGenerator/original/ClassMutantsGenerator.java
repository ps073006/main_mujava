// This is a mutant program.
// Author : ysma

package mujava;


import openjava.mop.*;
import openjava.ptree.*;
import java.io.*;
import mujava.op.*;
import mujava.op.util.*;
import mujava.util.Debug;


public class ClassMutantsGenerator extends mujava.MutantsGenerator
{

    boolean existIHD = false;

    java.lang.String[] classOp;

    public ClassMutantsGenerator( java.io.File f )
    {
        super( f );
        classOp = MutationSystem.cm_operators;
    }

    public ClassMutantsGenerator( java.io.File f, boolean debug )
    {
        super( f, debug );
        classOp = MutationSystem.cm_operators;
    }

    public ClassMutantsGenerator( java.io.File f, java.lang.String[] cOP )
    {
        super( f );
        classOp = cOP;
    }

     void genMutants()
    {
        if (comp_unit == null) {
            System.err.println( original_file + " is skipped." );
        }
        openjava.ptree.ClassDeclarationList cdecls = comp_unit.getClassDeclarations();
        if (cdecls == null || cdecls.size() == 0) {
            return;
        }
        if (classOp != null && classOp.length > 0) {
            Debug.println( "* Generating class mutants" );
            MutationSystem.clearPreviousClassMutants();
            MutationSystem.MUTANT_PATH = MutationSystem.CLASS_MUTANT_PATH;
            CodeChangeLog.openLogFile();
            genClassMutants( cdecls );
            CodeChangeLog.closeLogFile();
        }
    }

     void genClassMutants( openjava.ptree.ClassDeclarationList cdecls )
    {
        genClassMutants1( cdecls );
        genClassMutants2( cdecls );
    }

     void genClassMutants2( openjava.ptree.ClassDeclarationList cdecls )
    {
        for (int j = 0; j < cdecls.size(); ++j) {
            openjava.ptree.ClassDeclaration cdecl = cdecls.get( j );
            if (cdecl.getName().equals( MutationSystem.CLASS_NAME )) {
                mujava.op.util.DeclAnalyzer mutant_op;
                if (hasOperator( classOp, "IHD" )) {
                    Debug.println( "  Applying IHD ... ... " );
                    mutant_op = new mujava.op.IHD( file_env, null, cdecl );
                    generateMutant( mutant_op );
                    if (((mujava.op.IHD) mutant_op).getTotal() > 0) {
                        existIHD = true;
                    }
                }
                if (hasOperator( classOp, "IHI" )) {
                    Debug.println( "  Applying IHI ... ... " );
                    mutant_op = new mujava.op.IHI( file_env, null, cdecl );
                    generateMutant( mutant_op );
                }
                if (hasOperator( classOp, "IOD" )) {
                    Debug.println( "  Applying IOD ... ... " );
                    mutant_op = new mujava.op.IOD( file_env, null, cdecl );
                    generateMutant( mutant_op );
                }
                if (hasOperator( classOp, "OMR" )) {
                    Debug.println( "  Applying OMR ... ... " );
                    mutant_op = new mujava.op.OMR( file_env, null, cdecl );
                    generateMutant( mutant_op );
                }
                if (hasOperator( classOp, "OMD" )) {
                    Debug.println( "  Applying OMD ... ... " );
                    mutant_op = new mujava.op.OMD( file_env, null, cdecl );
                    generateMutant( mutant_op );
                }
                if (hasOperator( classOp, "JDC" )) {
                    Debug.println( "  Applying JDC ... ... " );
                    mutant_op = new mujava.op.JDC( file_env, null, cdecl );
                    generateMutant( mutant_op );
                }
            }
        }
    }

     void genClassMutants1( openjava.ptree.ClassDeclarationList cdecls )
    {
        for (int j = 0; j < cdecls.size(); ++j) {
            openjava.ptree.ClassDeclaration cdecl = cdecls.get( j );
            if (cdecl.getName().equals( MutationSystem.CLASS_NAME )) {
                java.lang.String qname = file_env.toQualifiedName( cdecl.getName() );
                try {
                    mujava.op.util.Mutator mutant_op;
                    if (hasOperator( classOp, "AMC" )) {
                        Debug.println( "  Applying AMC ... ... " );
                        mutant_op = new mujava.op.AMC( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "IOR" )) {
                        Debug.println( "  Applying IOR ... ... " );
                        try {
                            java.lang.Class parent_class = Class.forName( qname ).getSuperclass();
                            if (!parent_class.getName().equals( "java.lang.Object" )) {
                                java.lang.String temp_str = parent_class.getName();
                                java.lang.String result_str = "";
                                for (int k = 0; k < temp_str.length(); k++) {
                                    char c = temp_str.charAt( k );
                                    if (c == '.') {
                                        result_str = result_str + "/";
                                    } else {
                                        result_str = result_str + c;
                                    }
                                }
                                java.io.File f = new java.io.File( MutationSystem.SRC_PATH, result_str + ".java" );
                                if (f.exists()) {
                                    openjava.ptree.CompilationUnit[] parent_comp_unit = new openjava.ptree.CompilationUnit[1];
                                    openjava.mop.FileEnvironment[] parent_file_env = new openjava.mop.FileEnvironment[1];
                                    this.generateParseTree( f, parent_comp_unit, parent_file_env );
                                    this.initParseTree( parent_comp_unit, parent_file_env );
                                    mutant_op = new mujava.op.IOR( file_env, cdecl, comp_unit );
                                    ((mujava.op.IOR) mutant_op).setParentEnv( parent_file_env[0], parent_comp_unit[0] );
                                    comp_unit.accept( mutant_op );
                                }
                            }
                        } catch ( java.lang.ClassNotFoundException e ) {
                            System.out.println( " Exception at generating IOR mutant.  file : AllMutantsGenerator.java " );
                        } catch ( java.lang.NullPointerException e1 ) {
                            System.out.print( " IOP  ^^; " );
                        }
                    }
                    if (hasOperator( classOp, "ISD" )) {
                        Debug.println( "  Applying ISD ... ... " );
                        mutant_op = new mujava.op.ISD( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "IOP" )) {
                        Debug.println( "  Applying IOP ... ... " );
                        mutant_op = new mujava.op.IOP( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "IPC" )) {
                        Debug.println( "  Applying IPC ... ... " );
                        mutant_op = new mujava.op.IPC( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "PNC" )) {
                        Debug.println( "  Applying PNC ... ... " );
                        mutant_op = new mujava.op.PNC( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "PMD" )) {
                        Debug.println( "  Applying PMD ... ... " );
                        mutant_op = new mujava.op.PMD( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "PPD" )) {
                        Debug.println( "  Applying PPD ... ... " );
                        mutant_op = new mujava.op.PPD( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "PRV" )) {
                        Debug.println( "  Applying PRV ... ... " );
                        mutant_op = new mujava.op.PRV( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "PCI" )) {
                        Debug.println( "  Applying PCI ... ... " );
                        mutant_op = new mujava.op.PCI( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "PCC" )) {
                        Debug.println( "  Applying PCC ... ... " );
                        mutant_op = new mujava.op.PCC( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "PCD" )) {
                        Debug.println( "  Applying PCD ... ... " );
                        mutant_op = new mujava.op.PCD( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "JSD" )) {
                        Debug.println( "  Applying JSC ... ... " );
                        mutant_op = new mujava.op.JSD( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "JSI" )) {
                        Debug.println( "  Applying JSI ... ... " );
                        mutant_op = new mujava.op.JSI( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "JTD" )) {
                        Debug.println( "  Applying JTD ... ... " );
                        mutant_op = new mujava.op.JTD( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "JTI" )) {
                        Debug.println( "  Applying JTI ... ... " );
                        mutant_op = new mujava.op.JTI( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "JID" )) {
                        Debug.println( "  Applying JID ... ... " );
                        mutant_op = new mujava.op.JID( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "OAN" )) {
                        Debug.println( "  Applying OAN ... ... " );
                        mutant_op = new mujava.op.OAN( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "EOA" )) {
                        Debug.println( "  Applying EOA ... ... " );
                        mutant_op = new mujava.op.EOA( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "EOC" )) {
                        Debug.println( "  Applying EOC ... ... " );
                        mutant_op = new mujava.op.EOC( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "EAM" )) {
                        Debug.println( "  Applying EAM ... ... " );
                        mutant_op = new mujava.op.EAM( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                    if (hasOperator( classOp, "EMM" )) {
                        Debug.println( "  Applying EMM ... ... " );
                        mutant_op = new mujava.op.EMM( file_env, cdecl, comp_unit );
                        comp_unit.accept( mutant_op );
                    }
                } catch ( openjava.ptree.ParseTreeException e ) {
                    System.err.println( "Encountered errors during generating mutants." );
                    e.printStackTrace();
                }
            }
        }
    }

    public  void compileMutants()
    {
        if (classOp != null && classOp.length > 0) {
            Debug.println( "* Compiling class mutants into bytecode" );
            MutationSystem.MUTANT_PATH = MutationSystem.CLASS_MUTANT_PATH;
            super.compileMutants();
        }
    }

}
