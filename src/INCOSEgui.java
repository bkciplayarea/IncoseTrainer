// this tool provides the traning to the Incose system engineering process.
// for each process it lists all the input activites and output of the process.
// user can select a specific item and see details and learn more about that specific item of system engineering.
// baalaajee@gmail.com
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import java.awt.Font;

@SuppressWarnings({ "serial", "unused" })
public class INCOSEgui extends JDialog {

	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("rawtypes")
	private JList m_listInput;
	@SuppressWarnings("rawtypes")
	private JList m_listProcess;
	@SuppressWarnings("rawtypes")
	private JList m_listOutput;
	
	private int m_iSubProcessindex = 0;
	private int m_iMainProcessSelIndex = 0;
	
	@SuppressWarnings("rawtypes")
	private static  DefaultListModel idlm = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private static DefaultListModel pdlm = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private static DefaultListModel odlm = new DefaultListModel();
	
	private String s_mainpro_4 = "4. Technical Process";
	private String s_mainpro_5 = "5. Technical Management Processes";
	private String s_mainpro_6 = "6. Agreement Processes";
	private String s_mainpro_7 = "7. Organizational Project Enabling Processes";
	private String s_mainpro_8 = "8. Tailoring process and Application of SE";
	private String s_mainpro_9 = "9. Cross Cutting Systems Engineering Methods";
	private String s_mainpro_10 = "10. Specialty Engineering Activities";
	
	private String s_pro_4_1 = "4.1 Business or Mission Analysis";
	private String s_pro_4_2 = "4.2 Stakeholder Needs and Requirements Definition";
	private String s_pro_4_3 = "4.3 System Requirements Definition";
	private String s_pro_4_4 = "4.4 Architecture Definition";
	private String s_pro_4_5 = "4.5 Design Definition";
	private String s_pro_4_6 = "4.6 Syastem Analysis";
	private String s_pro_4_7 = "4.7 Implementation";
	private String s_pro_4_8 = "4.8 Integration";
	private String s_pro_4_9 = "4.9 Verification";
	private String s_pro_4_10 = "4.10 Transition";
	private String s_pro_4_11 = "4.11 Validation";
	private String s_pro_4_12 = "4.12 Operation";
	private String s_pro_4_13 = "4.13 Maintenance";
	private String s_pro_4_14 = "4.14 Disposal";
	
	private String s_pro_5_1 = "5.1 Project Planning Process";
	private String s_pro_5_2 = "5.2 Project Assessment and Control Process";
	private String s_pro_5_3 = "5.3 Decision Management Process";
	private String s_pro_5_4 = "5.4 Risk Management Process";
	private String s_pro_5_5 = "5.5 Configuration Management Process";
	private String s_pro_5_6 = "5.6 Information Management Process";
	private String s_pro_5_7 = "5.7 Measurement Process";
	private String s_pro_5_8 = "5.8 Quality Assurance Process";
	
	private String s_pro_6_1 = "6.1 Acquisition Process";
	private String s_pro_6_2 = "6.2 Supply Process";
	
	private String s_pro_7_1 = "7.1 Life Cycle Model Management Process";
	private String s_pro_7_2 = "7.2 Infrastructure Management Process";
	private String s_pro_7_3 = "7.3 Portfolio Management Process";
	private String s_pro_7_4 = "7.4 Human Resource Management Process";
	private String s_pro_7_5 = "7.5 Quality Management Process";
	private String s_pro_7_6 = "7.6 Knowledge Management Process";

	private String s_pro_8_1 = "8.1 Tailoring Process";
	private String s_pro_8_2 = "8.2 Tailoring for Specific Product Sector or Domain Application";
	private String s_pro_8_3 = "8.3 Application of Systems Engineering for Product Line Management";
	private String s_pro_8_4 = "8.4 Application of Systems Engineering for Services";
	private String s_pro_8_5 = "8.5 Application of Systems Engineering for Enterprises";
	private String s_pro_8_6 = "8.6 Application of Systems Engineering for Very Small and Micro Enterprises";
	
	private String s_pro_9_1 = "9.1 Modeling and Simulation";
	private String s_pro_9_2 = "9.2 Model Based Systems Engineering";
	private String s_pro_9_3 = "9.3 Functions Based Systems Engineering Method";
	private String s_pro_9_4 = "9.4 Object Oriented Systems Engineering Method";
	private String s_pro_9_5 = "9.5 Prototyping";
	private String s_pro_9_6 = "9.6 Interface Management";
	private String s_pro_9_7 = "9.7 Integrated Product and Process Development";
	private String s_pro_9_8 = "9.8 Lean Systems Engineering";
	private String s_pro_9_9 = "9.9 Agile Systems Engineering";
	
	private String s_pro_10_1 = "10.1 Affordability Cost Effectiveness  Life Cycle Cost Analysis";
	private String s_pro_10_2 = "10.2 Electromagnetic Compatibility";
	private String s_pro_10_3 = "10.3 Environmental Engineering Impact Analysis";
	private String s_pro_10_4 = "10.4 Interoperability Analysis";
	private String s_pro_10_5 = "10.5 Logistics Engineering";
	private String s_pro_10_6 = "10.6 Manufacturing and Producibility Analysis";
	private String s_pro_10_7 = "10.7 Mass Properties Engineering";
	private String s_pro_10_8 = "10.8 Reliability, Availability, and Maintainability";
	private String s_pro_10_9 = "10.9 Resilience Engineering";
	private String s_pro_10_10 = "10.10 System Safety Engineering";
	private String s_pro_10_11 = "10.11 System Security Engineering";
	private String s_pro_10_12 = "10.12 Training Needs Analysis";
	private String s_pro_10_13 = "10.13 Usability Analysis Human Systems Integration";
	private String s_pro_10_14 = "10.14 Value Engineering";

	
	//-------------------------------------
	
	private String s_pro_1_rem = "To define the business or mission problem or opportunity, characterize the solution space, and determine\r\n" + 
			"potential solution class(es) that could address a problem or take advantage of an opportunity.";
	
	private String s_pro_2_rem = "To define the stakeholder requirements for a system that can provide the capabilities needed by users and other stakeholders in a\r\n" +
			"defined environment.";
	
	private String s_pro_3_rem = "to transform the stakeholder, useroriented view of desired capabilities into a technical view\r\n" +
			"of a solution that meets the operational needs of the user.";
	
	private String s_pro_4_rem = "to generate system architecture alternatives, to select one or more alternative(s) that frame stakeholder\r\n" +
			"concerns and meet system requirements, and to express this in a set of consistent views.";
	
	private String s_pro_5_rem = "to provide sufficient detailed data and information about the system and its elements to enable the implementation\r\n" +
			"consistent with architectural entities as defined in models and views of the system architecture.";
	
	private String s_pro_6_rem = "to provide a rigorous basis of data and information for technical understanding to aid decision making across the life cycle.";
	private String s_pro_7_rem = "to realize a specified system element.";
	
	private String s_pro_8_rem = "to synthesize a set of system elements into a realized system (product or service) that satisfies system requirements,\r\n" +
									"architecture, and design.";
	
	private String s_pro_9_rem = "to provide objective evidence that a system or system element fulfils its specified requirements and characteristics.";
	
	private String s_pro_10_rem = "to establish a capability for a system to provide services specified by stakeholder requirements in the operational environment.";
	
	private String s_pro_11_rem = "to provide objective evidence that the system, when in use, fulfills its business or mission objectives and stakeholder\r\n" +
									"requirements, achieving its intended use in its intended operational environment.";
	
	private String s_pro_12_rem = "to use the system to deliver its services.";
	
	private String s_pro_13_rem = "to sustain the capability of the system to provide a service.";
		
	private String s_pro_14_rem = "to end the existence of a system element or system for a specified intended use, appropriately handle replaced \r\n" +
									"or retired elements, and to properly attend to identified critical disposal needs.";
	
	//------------------------------------------------------------------------------ 
	private static String s4_1_bizAn_I_1 = "Organization strategic plan"; 	
	private static String s4_1_bizAn_I_2 = "ConOps";						
	private static String s4_1_bizAn_I_3 = "Source documents";				
	private static String s4_1_bizAn_I_4 = "Life cycle constraints";		
	private static  String s4_1_bizAn_I_5 = "Project constraints";			
	private static String s4_1_bizAn_I_6 = "Stakeholder requirements traceability";	
	
	private String s4_1_bizAn_P_1 = "Prepare for business or mission analysis";
	private String s4_1_bizAn_P_2 = "Define the problem or opportunity space";
	private String s4_1_bizAn_P_3 = "Characterize the solution space";
	private String s4_1_bizAn_P_4 = "Evaluate alternative solution classes";
	private String s4_1_bizAn_P_5 = "Manage the Business or Mission Analysis";
	
	private String s4_1_bizAn_O_1 = "Business or mission analysis strategy";
	private String s4_1_bizAn_O_2 = "Major stakeholder identification";
	private String s4_1_bizAn_O_3 = "Preliminary life cycle concepts";
	private String s4_1_bizAn_O_4 = "Problem or opportunity statement";
	private String s4_1_bizAn_O_5 = "Business requirements";
	private String s4_1_bizAn_O_6 = "Alternative solution classes";
	private String s4_1_bizAn_O_7 = "Preliminary validation criteria";
	private String s4_1_bizAn_O_8 = "Preliminary MOE needs";
	private String s4_1_bizAn_O_9 = "Preliminary MOE data";
	private String s4_1_bizAn_O_10 = "Business requirements traceability";
	private String s4_1_bizAn_O_11 = "Business or mission analysis record";
	
	//------------------------------------------------------------------------------	
	private String s4_2_stak_I_1 = "Source documents";
	private String s4_2_stak_I_2 = "Project constraints";
	private String s4_2_stak_I_3 = "Major stakeholders identification";
	private String s4_2_stak_I_4 = "Preliminary life cycle concepts";
	private String s4_2_stak_I_5 = "Problem or opportunity statement";
	private String s4_2_stak_I_6 = "Business requirements";
	private String s4_2_stak_I_7 = "Alternative solution classes";
	private String s4_2_stak_I_8 = "Preliminary validation criteria";
	private String s4_2_stak_I_9 = "Validated requirements";
	private String s4_2_stak_I_10 = "Preliminary MOE needs";
	private String s4_2_stak_I_11 = "Preliminary MOE data";
	private String s4_2_stak_I_12 = "Business requirements traceability";
	private String s4_2_stak_I_13 = "Life cycle constraints";
	private String s4_2_stak_I_14 = "Stakeholder needs";
	private String s4_2_stak_I_15 = "System requirements traceability";	
	
	private String s4_2_stak_P_1 = "Prepare for stakeholder needs and requirements definition";	
	private String s4_2_stak_P_2 = "Define stakeholder needs";	
	private String s4_2_stak_P_3 = "Develop the operational concept and other life cycle concepts";	
	private String s4_2_stak_P_4 = "Transform stakeholder needs into stakeholder requirements";	
	private String s4_2_stak_P_5 = "Analyze stakeholder requirements";	
	private String s4_2_stak_P_6 = "Manage the stakeholder needs and requirements definition";	
	
	private String s4_2_stak_O_1 = "Stakeholder needs and requirements definition strategy";
	private String s4_2_stak_O_2 = "Life cycle concepts";
	private String s4_2_stak_O_3 = "System function identification";
	private String s4_2_stak_O_4 = "Stakeholder requirements";
	private String s4_2_stak_O_5 = "Validation criteria";
	private String s4_2_stak_O_6 = "MOE needs";
	private String s4_2_stak_O_7 = "MOE data";
	private String s4_2_stak_O_8 = "Stakeholder requirements traceability";
	private String s4_2_stak_O_9 = "Initial RVTM";
	private String s4_2_stak_O_10 = "Stakeholder needs and requirements definition record";
	
	//------------------------------------------------------------------------------	
	private String s4_3_sysReq_I_1 = "Life cycle concepts";
	private String s4_3_sysReq_I_2 = "System function identification";
	private String s4_3_sysReq_I_3 = "Stakeholder requirements";
	private String s4_3_sysReq_I_4 = "Stakeholder requirements traceability";
	private String s4_3_sysReq_I_5 = "Initial RVTM";
	private String s4_3_sysReq_I_6 = "Architecture traceability";
	private String s4_3_sysReq_I_7 = "Final RVTM";
	private String s4_3_sysReq_I_8 = "Life cycle constraints";
	
	private String s4_3_sysReq_P_1 = "Prepare for system requirements definition";
	private String s4_3_sysReq_P_2 = "Define system requirements";
	private String s4_3_sysReq_P_3 = "Analyze system requirements";
	private String s4_3_sysReq_P_4 = "Manage system requirements";
	
	private String s4_3_sysReq_O_1 = "System requirements definition strategy";
	private String s4_3_sysReq_O_2 = "System function definition";
	private String s4_3_sysReq_O_3 = "System requirements";
	private String s4_3_sysReq_O_4 = "System functional interface identification";
	private String s4_3_sysReq_O_5 = "Verification criteria";
	private String s4_3_sysReq_O_6 = "MOP needs";
	private String s4_3_sysReq_O_7 = "MOP data";
	private String s4_3_sysReq_O_8 = "System requirements traceability";
	private String s4_3_sysReq_O_9 = "Updated RVTM";
	private String s4_3_sysReq_O_10 = "System requirements definition record";
	
	//------------------------------------------------------------------------------	
	private String s4_4_arch_I_1 = "Life cycle concepts";
	private String s4_4_arch_I_2 = "System function definition";
	private String s4_4_arch_I_3 = "System requirements";
	private String s4_4_arch_I_4 = "System functional interface identification";
	private String s4_4_arch_I_5 = "System requirements traceability";
	private String s4_4_arch_I_6 = "Updated RVTM";
	private String s4_4_arch_I_7 = "Design traceability";
	private String s4_4_arch_I_8 = "Interface definition update identification";
	private String s4_4_arch_I_9 = "Life cycle constraints";
	
	private String s4_4_arch_P_1 = "Prepare for architecture definition";
	private String s4_4_arch_P_2 = "Develop architecture viewpoints";
	private String s4_4_arch_P_3 = "Develop models and views of candidate architectures";
	private String s4_4_arch_P_4 = "Relate the architecture to design";
	private String s4_4_arch_P_5 = "Assess architecture candidates";
	private String s4_4_arch_P_6 = "Manage the selected architecture";
	
	private String s4_4_arch_O_1 = "Architecture definition strategy";
	private String s4_4_arch_O_2 = "System architecture description";
	private String s4_4_arch_O_3 = "System architecture rationale";
	private String s4_4_arch_O_4 = "Documentation tree";
	private String s4_4_arch_O_5 = "Preliminary interface definition";
	private String s4_4_arch_O_6 = "Preliminary TPM needs";
	private String s4_4_arch_O_7 = "Preliminary TPM data";
	private String s4_4_arch_O_8 = "Architecture traceability";
	private String s4_4_arch_O_9 = "Architecture definition record";
	
	//------------------------------------------------------------------------------	
	private String s4_5_desig_I_1 = "Life cycle concepts";
	private String s4_5_desig_I_2 = "System function definition";
	private String s4_5_desig_I_3 = "System requirements";
	private String s4_5_desig_I_4 = "System functional interface identification";
	private String s4_5_desig_I_5 = "System architecture description";
	private String s4_5_desig_I_6 = "System architecture rationale";
	private String s4_5_desig_I_7 = "Preliminary interface definition";
	private String s4_5_desig_I_8 = "Preliminary TPM needs";
	private String s4_5_desig_I_9 = "Preliminary TPM data";
	private String s4_5_desig_I_10 = "Architecture traceability";
	private String s4_5_desig_I_11 = "Interface definition update identification";
	private String s4_5_desig_I_12 = "Implementation traceability";
	private String s4_5_desig_I_13 = "Life cycle constraints";
	
	private String s4_5_desig_P_1 = "Prepare for design definition";
	private String s4_5_desig_P_2 = "Establish design characteristics and design enablers related to each system element";
	private String s4_5_desig_P_3 = "Assess alternatives for obtaining system elements";
	private String s4_5_desig_P_4 = "Manage the design";
	
	private String s4_5_desig_O_1 = "Design definition strategy";
	private String s4_5_desig_O_2 = "System design description";
	private String s4_5_desig_O_3 = "System design rationale";
	private String s4_5_desig_O_4 = "Interface definition";
	private String s4_5_desig_O_5 = "TPM needs";
	private String s4_5_desig_O_6 = "TPM data";
	private String s4_5_desig_O_7 = "Design traceability";
	private String s4_5_desig_O_8 = "System element descriptions";
	private String s4_5_desig_O_9 = "Design definition record";
	
	//---------------------
	private String s4_6_SysAn_I_1 = "Life cycl econcepts";
	private String s4_6_SysAn_I_2 = "Analysis Situations";
	private String s4_6_SysAn_I_3 = "Life cycle constraints";

	private String s4_6_SysAn_P_1 = "prepare for system analysis";
	private String s4_6_SysAn_P_2 = "perform system analysis";
	private String s4_6_SysAn_P_3 = "manage system analysis";

	private String s4_6_SysAn_O_1 = "system analysis strategy";
	private String s4_6_SysAn_O_2 = "system analysis report";
	private String s4_6_SysAn_O_3 = "system analysis record";
	
	//---------------------
	private String s4_7_Impl_I_1 = "Life cycle concepts";
	private String s4_7_Impl_I_2 = "System architecture description";
	private String s4_7_Impl_I_3 = "System architecture rationale";
	private String s4_7_Impl_I_4 = "System design description";
	private String s4_7_Impl_I_5 = "System design rationale";
	private String s4_7_Impl_I_6 = "Interface definition";
	private String s4_7_Impl_I_7 = "Design traceability";
	private String s4_7_Impl_I_8 = "System element descriptions";

	private String s4_7_Impl_P_1 = "Prepare for implementation";
	private String s4_7_Impl_P_2 = "Perform implementation";
	private String s4_7_Impl_P_3 = "Manage results of implementation";

	private String s4_7_Impl_O_1 = "Implementation strategy";
	private String s4_7_Impl_O_2 = "Implementation enabling system requirements";
	private String s4_7_Impl_O_3 = "Implementation constraints";
	private String s4_7_Impl_O_4 = "System elements";
	private String s4_7_Impl_O_5 = "System element documentation";
	private String s4_7_Impl_O_6 = "Operator/maintainer training materials";
	private String s4_7_Impl_O_7 = "Implementation traceability";
	private String s4_7_Impl_O_8 = "Implementation report";
	private String s4_7_Impl_O_9 = "Implementation record";
	
	//------------------------------------------------------------------------------	
	private String s4_8_Integ_I_1 = "Life Cycle Concepts";
	private String s4_8_Integ_I_2 = "Interface Definition";
	private String s4_8_Integ_I_3 = "System Element Descriptions";
	private String s4_8_Integ_I_4 = "System elements";
	private String s4_8_Integ_I_5 = "System element documentation";
	private String s4_8_Integ_I_6 = "Implementation traceability";
	private String s4_8_Integ_I_7 = "Accepted system or system element";
	
	private String s4_8_Integ_P_1 = "Prepare for Integration";
	private String s4_8_Integ_P_2 = "Perform Integration";
	private String s4_8_Integ_P_3 = "Manage Results of Integration";
	
	private String s4_8_Integ_O_1 = "Integration Strategy";
	private String s4_8_Integ_O_2 = "Integration Enabling System Requirements";
	private String s4_8_Integ_O_3 = "Integration constraints";
	private String s4_8_Integ_O_4 = "Integration procedure";
	private String s4_8_Integ_O_5 = "Integrated system or system elements";
	private String s4_8_Integ_O_6 = "Interface definition update identification";
	private String s4_8_Integ_O_7 = "Integration report";
	private String s4_8_Integ_O_8 = "Integration record";
	
	//------------------------------------------------------------
	private String s4_9_Veri_I_1 = "Life cycle concepts";
	private String s4_9_Veri_I_2 = "System requirements";
	private String s4_9_Veri_I_3 = "Verification criteria";
	private String s4_9_Veri_I_4 = "Updated RVTM";
	private String s4_9_Veri_I_5 = "Interface definition";
	private String s4_9_Veri_I_6 = "Integrated system or system elements";
	private String s4_9_Veri_I_7 = "Integration report";

	private String s4_9_Veri_P_1 = "Prepare for verification";
	private String s4_9_Veri_P_2 = "Perform verification";
	private String s4_9_Veri_P_3 = "Manage results of verification";

	private String s4_9_Veri_O_1 = "Verification strategy";
	private String s4_9_Veri_O_2 = "Verification enabling system requirements";
	private String s4_9_Veri_O_3 = "Verification constraints";
	private String s4_9_Veri_O_4 = "Verification procedure";
	private String s4_9_Veri_O_5 = "Final RVTM";
	private String s4_9_Veri_O_6 = "Verified system";
	private String s4_9_Veri_O_7 = "Verification Report";
	private String s4_9_Veri_O_8 = "Verification Record";
	
	//-------------------------------
	private String s4_10_Tran_I_1 = "Life cycle concepts";
	private String s4_10_Tran_I_2 = "Operator/maintainer training material";
	private String s4_10_Tran_I_3 = "Final RTVM";
	private String s4_10_Tran_I_4 = "Verified system";
	private String s4_10_Tran_I_5 = "Verification report";

	private String s4_10_Tran_P_1 = "Prepare for the transition";
	private String s4_10_Tran_P_2 = "Perform the transition";
	private String s4_10_Tran_P_3 = "Manage results of transition";

	private String s4_10_Tran_O_1 = "Transition strategy";
	private String s4_10_Tran_O_2 = "Transition enabling system requirements";
	private String s4_10_Tran_O_3 = "Transition constraints";
	private String s4_10_Tran_O_4 = "Installation procedure";
	private String s4_10_Tran_O_5 = "Installed system";
	private String s4_10_Tran_O_6 = "Trained operators and maintainers";
	private String s4_10_Tran_O_7 = "ransition report";
	private String s4_10_Tran_O_8 = "Transition record";
	
	//------------------------------------------
	private String s4_11_Vali_I_1 = "Life cycle concepts";
	private String s4_11_Vali_I_2 = "Stakeholder requirements";
	private String s4_11_Vali_I_3 = "final RVTM";
	private String s4_11_Vali_I_4 = "installed system";
	private String s4_11_Vali_I_5 = "transition report";
	private String s4_11_Vali_I_6 = "vlidation criteria";
	
	private String s4_11_Vali_P_1 = "Prepare for validation";
	private String s4_11_Vali_P_2 = "Perform validation";
	private String s4_11_Vali_P_3 = "Manage results of validation";
	
	private String s4_11_Vali_O_1 = "Validation strategy";
	private String s4_11_Vali_O_2 = "Validation enabling system requirements";
	private String s4_11_Vali_O_3 = "Validation constraints";
	private String s4_11_Vali_O_4 = "Validation procedure";

	//----------------------------
	private String s4_12_Oper_I_1 = "Life cycle concepts";
	private String s4_12_Oper_I_2 = "operator/maintainer traning material";
	private String s4_12_Oper_I_3 = "trained operators and mainteners";
	private String s4_12_Oper_I_4 = "validated system";
	private String s4_12_Oper_I_5 = "validation report";
	private String s4_12_Oper_I_6 = "maintenance report";
	
	private String s4_12_Oper_P_1 = "prepare for operation";
	private String s4_12_Oper_P_2 = "perform operation";
	private String s4_12_Oper_P_3 = "manage results of operation";
	private String s4_12_Oper_P_4 = "support the customer";
	
	private String s4_12_Oper_O_1 = "operation strategy";
	private String s4_12_Oper_O_2 = "operation enabling system requirements";
	private String s4_12_Oper_O_3 = "operations constraints";
	private String s4_12_Oper_O_4 = "operation report";
	private String s4_12_Oper_O_5 = "operation record";
	
	//----------------------
	private String s4_13_Main_I_1 = "Life cycle concepts";
	private String s4_13_Main_I_2 = "operator/maintainer traning material";
	private String s4_13_Main_I_3 = "trained operators and mainteners";
	private String s4_13_Main_I_4 = "validated system";
	private String s4_13_Main_I_5 = "validation report";
	private String s4_13_Main_I_6 = "operation report";
	
	private String s4_13_Main_P_1 = "Prepare for maintenance";
	private String s4_13_Main_P_2 = "perform maintenance";
	private String s4_13_Main_P_3 = "perform logistics support";
	private String s4_13_Main_P_4 = "manage results of maintenance and logistics";
	
	private String s4_13_Main_O_1 = "Maintenance strategy";
	private String s4_13_Main_O_2 = "Maintenance enebling system requirements";
	private String s4_13_Main_O_3 = "Maintenance constraints";
	private String s4_13_Main_O_4 = "Maintenance procedure";
	private String s4_13_Main_O_5 = "Maintenance report";
	private String s4_13_Main_O_6 = "Maintenance recprd";

	//-------------------
	private String s4_14_Disp_I_1 = "Life Cycle Concenpts";
	private String s4_14_Disp_I_2 = "Validated System";
	private String s4_14_Disp_I_3 = "Operation Report";
	private String s4_14_Disp_I_4 = "Maintenance Report";
	
	private String s4_14_Disp_P_1 = "Prepare for Disposal";
	private String s4_14_Disp_P_2 = "Perform Disposal";
	private String s4_14_Disp_P_3 = "Finalize the Disposal";
	
	private String s4_14_Disp_O_1 = "Disposal Strategy";
	private String s4_14_Disp_O_2 = "Disposal Enabling System Requirements";
	private String s4_14_Disp_O_3 = "Disposal Constraints";
	private String s4_14_Disp_O_4 = "Disposal Procedure";
	private String s4_14_Disp_O_5 = "Disposal System";
	private String s4_14_Disp_O_6 = "Disposal report";
	private String s4_14_Disp_O_7 = "Disposal record";
	
	
	//------------------------------------------------------------------------------ 
	private static String s5_1_techManPro_I_1 = "Organization strategic plan";
	private static String s5_1_techManPro_I_2 = "Source documents";
	private static String s5_1_techManPro_I_3 = "Supply response";
	private static String s5_1_techManPro_I_4 = "Project portfolio";
	private static String s5_1_techManPro_I_5 = "Life cycle models";
	private static String s5_1_techManPro_I_6 = "Project direction";
	private static String s5_1_techManPro_I_7 = "Strategy documents";
	private static String s5_1_techManPro_I_8 = "Project tailoring strategy";
	private static String s5_1_techManPro_I_9 = "Project lessons learned";
	private static String s5_1_techManPro_I_10 = "Documentation tree";
	private static String s5_1_techManPro_I_11 = "QM corrective actions";
	private static String s5_1_techManPro_I_12 = "Qualfied personnel";
	private static String s5_1_techManPro_I_13 = "Quality assurance plan";
	
	private static String s5_1_techManPro_P_1 = "Define the project";
	private static String s5_1_techManPro_P_2 = "Plan project and technical management";
	private static String s5_1_techManPro_P_3 = "Activate the project";
	
	private static String s5_1_techManPro_O_1 = "SEMP";
	private static String s5_1_techManPro_O_2 = "Project constraints";
	private static String s5_1_techManPro_O_3 = "Project infrastructure needs";
	private static String s5_1_techManPro_O_4 = "Project human resources needs";
	private static String s5_1_techManPro_O_5 = "WBS";
	private static String s5_1_techManPro_O_6 = "Project schedule";
	private static String s5_1_techManPro_O_7 = "Project budget";
	private static String s5_1_techManPro_O_8 = "Acquisition need";
	private static String s5_1_techManPro_O_9 = "Project planning record";
	
	//--------------------------------------------------------------------------
	private static String s5_2_projAssCtrl_I_1 = "WBS";
	private static String s5_2_projAssCtrl_I_2 = "Project Budget";
	private static String s5_2_projAssCtrl_I_3 = "Project Schedule";
	private static String s5_2_projAssCtrl_I_4 = "Procedures";
	private static String s5_2_projAssCtrl_I_5 = "Reports";
	private static String s5_2_projAssCtrl_I_6 = "Configuration Baselines";
	private static String s5_2_projAssCtrl_I_7 = "Information Repository";
	private static String s5_2_projAssCtrl_I_8 = "Measurement Repository";
	private static String s5_2_projAssCtrl_I_9 = "QM Corrective Actions";
	private static String s5_2_projAssCtrl_I_10 = "QA Evaluation Report";
	private static String s5_2_projAssCtrl_I_11 = "Validated Requirements";
	
	private static String s5_2_projAssCtrl_P_1 = "Plan for project Assessment and Control";
	private static String s5_2_projAssCtrl_P_2 = "Assess the Porject";
	private static String s5_2_projAssCtrl_P_3 = "Control the Porject";
	
	private static String s5_2_projAssCtrl_O_1 = "Project Assessment and Control Strategy";
	private static String s5_2_projAssCtrl_O_2 = "Project Performance Measures Needs";
	private static String s5_2_projAssCtrl_O_3 = "Project Performance Measures Data";
	private static String s5_2_projAssCtrl_O_4 = "Project Status Report";
	private static String s5_2_projAssCtrl_O_5 = "Project Control Requests";
	private static String s5_2_projAssCtrl_O_6 = "Project Change Requests";
	private static String s5_2_projAssCtrl_O_7 = "Project Lessons Learned";
	private static String s5_2_projAssCtrl_O_8 = "Project Assessment and Control Record";
	
	//-------------------
	private static String s5_3_DeciManPro_I_1 = "Decision Situation";

	private static String s5_3_DeciManPro_P_1 = "Prepare for Decisions";
	private static String s5_3_DeciManPro_P_2 = "Analyze the Decision Information";
	private static String s5_3_DeciManPro_P_3 = "Make and Manage Decisions";

	private static String s5_3_DeciManPro_O_1 = "Decision Management Strategy";
	private static String s5_3_DeciManPro_O_2 = "Decision Report";
	private static String s5_3_DeciManPro_O_3 = "Decision Record";
	
	//-------------------
	private static String s5_4_RiskMan_I_1 = "Candidate Risks and Opportunities";

	private static String s5_4_RiskMan_P_1 = "Plan Risk Management";
	private static String s5_4_RiskMan_P_2 = "Manage Risk Profile";
	private static String s5_4_RiskMan_P_3 = "Analyze Risks";
	private static String s5_4_RiskMan_P_4 = "Treat Risks";
	private static String s5_4_RiskMan_P_5 = "Monitor Risks";

	private static String s5_4_RiskMan_O_1 = "Risk Management Strategy";
	private static String s5_4_RiskMan_O_2 = "Risk Report";
	private static String s5_4_RiskMan_O_3 = "Risk Record";
	
	//-------------------
	private static String s5_5_ConfigMan_I_1 = "Candidate Configuration Items";
	private static String s5_5_ConfigMan_I_2 = "Project Change Request";

	private static String s5_5_ConfigMan_P_1 = "Plan configuration management";
	private static String s5_5_ConfigMan_P_2 = "Perform configuration identification";
	private static String s5_5_ConfigMan_P_3 = "Perform configuration change management";
	private static String s5_5_ConfigMan_P_4 = "Perform configuration status accounting";
	private static String s5_5_ConfigMan_P_5 = "Perform configuration evaluation";
	private static String s5_5_ConfigMan_P_6 = "Perform release control";

	private static String s5_5_ConfigMan_O_1 = "Configuration management strategy";
	private static String s5_5_ConfigMan_O_2 = "Configuration baselines";
	private static String s5_5_ConfigMan_O_3 = "Configuration management report";
	private static String s5_5_ConfigMan_O_4 = "Configuration management record";
	
	//-------------------
	private static String s5_6_InfoMan_I_1 = "Candidate Information Items";
	private static String s5_6_InfoMan_I_2 = "Project Change Requests";

	private static String s5_6_InfoMan_P_1 = "Prepare for Information Management";
	private static String s5_6_InfoMan_P_2 = "Perform Information Management";

	private static String s5_6_InfoMan_O_1 = "Information management strategy";
	private static String s5_6_InfoMan_O_2 = "Information Repository";
	private static String s5_6_InfoMan_O_3 = "Information Management Report";
	private static String s5_6_InfoMan_O_4 = "identification management record";
	
	//-------------------
	private static String s5_7_MeasMan_I_1 = "Measurement Needs";
	private static String s5_7_MeasMan_I_2 = "Measurement data";

	private static String s5_7_MeasMan_P_1 = "Prepare for measurement";
	private static String s5_7_MeasMan_P_2 = "Perform measurement";

	private static String s5_7_MeasMan_O_1 = "measurement strategy";
	private static String s5_7_MeasMan_O_2 = "measurement Repository";
	private static String s5_7_MeasMan_O_3 = "measurement Report";
	private static String s5_7_MeasMan_O_4 = "measurement record";
	
	//-------------------
	private static String s5_8_QualMan_I_1 = "Quality management guidelines";
	private static String s5_8_QualMan_I_2 = "quality management plan";
	private static String s5_8_QualMan_I_3 = "quality management report";
	private static String s5_8_QualMan_I_4 = "QM Corrective actions";

	private static String s5_8_QualMan_P_1 = "Prepare for QA";
	private static String s5_8_QualMan_P_2 = "Perform product or service evaluations";
	private static String s5_8_QualMan_P_3 = "perform Process evaluations";
	private static String s5_8_QualMan_P_4 = "Manage QA record and report";
	private static String s5_8_QualMan_P_5 = "Treat incidents and problems";

	private static String s5_8_QualMan_O_1 = "quality assurance plan";
	private static String s5_8_QualMan_O_2 = "quality assurance report";
	private static String s5_8_QualMan_O_3 = "quality assurance evaluations report";
	private static String s5_8_QualMan_O_4 = "quality assurance record";
	
	//-------------------
	private String s6_1_Agree_I_1 = "Organization strategic plan";
	private String s6_1_Agree_I_2 = "Acquisition need";
	private String s6_1_Agree_I_3 = "Enabling system requirements";
	private String s6_1_Agree_I_4 = "Acquisition reply";
	private String s6_1_Agree_I_5 = "Acquired system";
	
	private String s6_1_Agree_P_1 = "Prepare for the acquisition";
	private String s6_1_Agree_P_2 = "Advertise the acquisition and select the supplier";
	private String s6_1_Agree_P_3 = "Establish and maintain an agreement";
	private String s6_1_Agree_P_4 = "Monitor the agreement";
	private String s6_1_Agree_P_5 = "Accept the product or service";
		
	private String s6_1_Agree_O_1 = "Acquisition strategy";
	private String s6_1_Agree_O_2 = "Request for supply";
	private String s6_1_Agree_O_3 = "Acquisition agreement";
	private String s6_1_Agree_O_4 = "Accepted system or system element";
	private String s6_1_Agree_O_5 = "Acquisition payment";
	private String s6_1_Agree_O_6 = "Acquisition report";
	private String s6_1_Agree_O_7 = "Acquisition record";
	
	//-------------------
	private String s6_2_Agree_I_1 = "Organization strategic plan";
	private String s6_2_Agree_I_2 = "Request for supply";
	private String s6_2_Agree_I_3 = "Supply payment";
	private String s6_2_Agree_I_4 = "Validated system";
	private String s6_2_Agree_I_5 = "Disposed system";	
	
	private String s6_2_Agree_P_1 = "Prepare for the supply";
	private String s6_2_Agree_P_2 = "Respond to a tender";
	private String s6_2_Agree_P_3 = "Establish and maintain an agreement ";
	private String s6_2_Agree_P_4 = "Execute the agreement";
	private String s6_2_Agree_P_5 = "Deliver and support the product or service";
		
	private String s6_2_Agree_O_1 = "Supply strategy";
	private String s6_2_Agree_O_2 = "Supply response";
	private String s6_2_Agree_O_3 = "Supply agreement";
	private String s6_2_Agree_O_4 = "Supplied system";
	private String s6_2_Agree_O_5 = "Supply report";
	private String s6_2_Agree_O_6 = "Supply record";
	
	//---------------------------------
	private  String s7_1_LifCycMod_I_1 = "Organization strategic plan";
	private  String s7_1_LifCycMod_I_2 = "Organization tailoring strategy";
	private  String s7_1_LifCycMod_I_3 = "Quality management evaluation report";
	private  String s7_1_LifCycMod_I_4 = "QM corrective actions";

	private  String s7_1_LifCycMod_P_1 = "Establish the process";
	private  String s7_1_LifCycMod_P_2 = "Assess the process";
	private  String s7_1_LifCycMod_P_3 = "Improve the process";

	private  String s7_1_LifCycMod_O_1 = "Life cycle model management plan";
	private  String s7_1_LifCycMod_O_2 = "Organization policies,procedures, and assets";
	private  String s7_1_LifCycMod_O_3 = "Life cycle models";
	private  String s7_1_LifCycMod_O_4 = "Organizational process performance measures needs";
	private  String s7_1_LifCycMod_O_5 = "Organizational process performance measures data";
	private  String s7_1_LifCycMod_O_6 = "Life cycle model management report";
	private  String s7_1_LifCycMod_O_7 = "Life cycle model management record";
	
	//---------------------------------
	private static String s7_2_InfrMan_I_1 = "Organization strategic plan";
	private static String s7_2_InfrMan_I_2 = "Organization infrastructure needs";
	private static String s7_2_InfrMan_I_3 = "Project infrastructure needs";

	private static String s7_2_InfrMan_P_1 = "Establish the infrastructure";
	private static String s7_2_InfrMan_P_2 = "Maintain the infrastructure";

	private static String s7_2_InfrMan_O_1 = "Infrastructure management plan";
	private static String s7_2_InfrMan_O_2 = "Infrastructure management report";
	private static String s7_2_InfrMan_O_3 = "Infrastructure management record";
	private static String s7_2_InfrMan_O_4 = "Organization infrastructure";
	private static String s7_2_InfrMan_O_5 = "Project infrastructure";
	
	//---------------------------------
	private static String s7_3_PortfoMan_I_1 = "Organization strategic plan";
	private static String s7_3_PortfoMan_I_2 = "Organization portfolio direction and constraints";
	private static String s7_3_PortfoMan_I_3 = "Supply strategy";
	private static String s7_3_PortfoMan_I_4 = "Project status report";

	private static String s7_3_PortfoMan_P_1 = "Define and authorize projects";
	private static String s7_3_PortfoMan_P_2 = "Evaluate the portfolio of projects";
	private static String s7_3_PortfoMan_P_3 = "Terminate projects";

	private static String s7_3_PortfoMan_O_1 = "Portfolio management plan";
	private static String s7_3_PortfoMan_O_2 = "Organization infrastructure needs";
	private static String s7_3_PortfoMan_O_3 = "Project direction";
	private static String s7_3_PortfoMan_O_4 = "Project portfolio";
	private static String s7_3_PortfoMan_O_5 = "Organization lesson learned";
	private static String s7_3_PortfoMan_O_6 = "Portfolio management report";
	private static String s7_3_PortfoMan_O_7 = "Portfolio management record";
	
	
	private static String s7_4_HR_I_1 = "Organization strategic plan";
	private static String s7_4_HR_I_2 = "Project portfolio";
	private static String s7_4_HR_I_3 = "Project human resources needs";

	private static String s7_4_HR_P_1 = "Identify skills";
	private static String s7_4_HR_P_2 = "Develop skills";
	private static String s7_4_HR_P_3 = "Acquire and provide skills";

	private static String s7_4_HR_O_1 = "Human resource management plan";
	private static String s7_4_HR_O_2 = "Qualified personnel";
	private static String s7_4_HR_O_3 = "Human resource management report";
	private static String s7_4_HR_O_4 = "Human resource management record";
	
	private static String s7_5_QualMan_I_1 = "Organization strategic plan";
	private static String s7_5_QualMan_I_2 = "Quality assurance plan";
	private static String s7_5_QualMan_I_3 = "Quality assurance report";
	private static String s7_5_QualMan_I_4 = "Quality assurance evaluation report";
	private static String s7_5_QualMan_I_5 = "Customer satisfaction inputs";

	private static String s7_5_QualMan_P_1 = "Plan quality management";
	private static String s7_5_QualMan_P_2 = "Assess quality management";
	private static String s7_5_QualMan_P_3 = "Perform quality management corrective";
	private static String s7_5_QualMan_P_4 = "action and preventive action";

	private static String s7_5_QualMan_O_1 = "Quality management plan";
	private static String s7_5_QualMan_O_2 = "Quality management guidelines";
	private static String s7_5_QualMan_O_3 = "QM corrective actions";
	private static String s7_5_QualMan_O_4 = "Quality management report";
	private static String s7_5_QualMan_O_5 = "Quality management evaluation report";
	private static String s7_5_QualMan_O_6 = "Quality management record";
	
	private static String s7_6_KnowMan_I_1 = "Organization strategic plan";
	private static String s7_6_KnowMan_I_2 = "Organization lessons learned";
	private static String s7_6_KnowMan_I_3 = "Project lessons learned Records";

	private static String s7_6_KnowMan_P_1 = "Plan knowledge management";
	private static String s7_6_KnowMan_P_2 = "Share knowledge and skills throughout the organization";
	private static String s7_6_KnowMan_P_3 = "Share knowledge assets throughout the organization";
	private static String s7_6_KnowMan_P_4 = "Manage knowledge, skills, and knowledge assets";

	private static String s7_6_KnowMan_O_1 = "knowledge management plan";
	private static String s7_6_KnowMan_O_2 = "knowledge management system";
	private static String s7_6_KnowMan_O_3 = "knowledge management report";
	
	
	private static String s8_1_TailProc_I_1 = "Organization strategic plan";
	private static String s8_1_TailProc_I_2 = "Life cycle models";

	private static String s8_1_TailProc_P_1 = "Identity and record the circumstances that influence tailoring";
	private static String s8_1_TailProc_P_2 = "Take due account of the life cycle structures recommended or mandated by standards";
	private static String s8_1_TailProc_P_3 = "Obtain input from parties affected by the tailoring decisions";
	private static String s8_1_TailProc_P_4 = "Make tailoring decisions";
	private static String s8_1_TailProc_P_5 = "Select life cycle processes that require tailoring";

	private static String s8_1_TailProc_O_1 = "Organization tailoring strategy";
	private static String s8_1_TailProc_O_2 = "Project tailoring strategy";
	
	
	private JLabel lblSelectASe;
	@SuppressWarnings("rawtypes")
	private JComboBox m_comboBoxSEProcess;
	@SuppressWarnings("rawtypes")
	private JComboBox m_comboBoxMainSE;
	private JLabel lblSelectedProcessIpo;
	private JLabel lblInput;
	private JLabel lblProcess;
	private JLabel lblOutput;
	private JLabel lblRemarks;
	private JTextArea m_textAreaIPORemarks;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;

	private JScrollPane scrollPane_3;
	
	//rem descriptions for IPO
	private static String[][] m_4_1_bizAnRemarks = new String[3][15];
	private static String[][] m_4_2_stakRemarks = new String[3][15]; 
	private static String[][] m_4_8_integRemarks = new String[3][15];
	private static String[][] m_4_9_veriRemarks = new String[3][15]; 
	private static String[][] m_6_1_agreeRemarks = new String[3][15];
	 	
	// files 
	private static String INCOSE_REMARKS_FOLDER = "Incose_Stuff";
	private static String INCOSE_4_1_BIZ_AN_REMARKS = "IncoseContent_4_1_bizAnRemarks.balaji";
	private static String INCOSE_4_2_STAK_REMARKS 	= "IncoseContent_4_2_stakRemarks.balaji";
	private static String INCOSE_4_8_INTEG_REMARKS 	= "IncoseContent_4_8_integRemarks.balaji";
	private static String INCOSE_4_9_VERI_REMARKS 	= "IncoseContent_4_9_veriRemarks.balaji";
	private static String INCOSE_6_1_AGREE_REMARKS 	= "IncoseContent_6_1_agreeRemarks.balaji";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			INCOSEgui dialog = new INCOSEgui();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Starting INCOSE Training Tool.");
		initApp();
	}
	
	public static void initApp()
	{		
		for(int i=0; i<3; i++)  {
			for(int j=0; j<15; j++) {
				m_4_1_bizAnRemarks[i][j] = "";
				m_4_2_stakRemarks[i][j] = "";
				m_4_8_integRemarks[i][j] = "";
				m_4_9_veriRemarks[i][j] = "";
			}
		}
		populateRemarksfromFile();
	}
	
	public static void populateRemarksfromFile()
	{
		populateRemarksfromFile_4_1_bizAnRemarks();
		populateRemarksfromFile_4_2_stakRemarks();
		
		populateRemarksfromFile_4_8_integRemarks();
		populateRemarksfromFile_4_9_veriRemarks();
		
		populateRemarksfromFile_6_1_agreeRemarks();
	}
	
	
	private static void populateRemarksfromFile_4_8_integRemarks()
	{
		String contentFilepath = ".\\" + INCOSE_REMARKS_FOLDER +  "\\" +  INCOSE_4_8_INTEG_REMARKS;
		
		boolean isInputRem = false; boolean isProcessRem = false; boolean isOutputRem = false;
		
		int procInderx = 0; int procitemIndex = 0; 
		
		try (BufferedReader br = new BufferedReader(new FileReader(contentFilepath))) {
            String line;
            while ((line = br.readLine()) != null) 
            {
            	if ( (line.substring(0, 2)).compareTo("//") == 0  ) //ignore comment
            		continue;
            	
            	if ( line.compareTo("#START_INPUT_PROC") == 0  )
            	{
            		isInputRem = true; isProcessRem = false; isOutputRem = false;
            		procInderx = 0; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isInputRem) 
            	{
            		//line = br.readLine();
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_8_integRemarks[procInderx][procitemIndex] = m_4_8_integRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//Process items population
            	if ( line.compareTo("#START_PROC_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = true; isOutputRem = false;
            		procInderx = 1; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isProcessRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_8_integRemarks[procInderx][procitemIndex] = m_4_8_integRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//output items population
            	if ( line.compareTo("#START_OUTPUT_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = false; isOutputRem = true;
            		procInderx = 2; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isOutputRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_8_integRemarks[procInderx][procitemIndex] = m_4_8_integRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            }//main while
        } catch (IOException e) { e.printStackTrace(); }
	}
		
	private static void populateRemarksfromFile_4_9_veriRemarks()
	{
		String contentFilepath = ".\\" + INCOSE_REMARKS_FOLDER +  "\\" +  INCOSE_4_9_VERI_REMARKS;
		boolean isInputRem = false; boolean isProcessRem = false; boolean isOutputRem = false;
		
		int procInderx = 0; int procitemIndex = 0; 
		
		try (BufferedReader br = new BufferedReader(new FileReader(contentFilepath))) {
            String line;
            while ((line = br.readLine()) != null) 
            {
            	if ( (line.substring(0, 2)).compareTo("//") == 0  ) //ignore comment
            		continue;
            	
            	if ( line.compareTo("#START_INPUT_PROC") == 0  )
            	{
            		isInputRem = true; isProcessRem = false; isOutputRem = false;
            		procInderx = 0; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isInputRem) 
            	{
            		//line = br.readLine();
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_9_veriRemarks[procInderx][procitemIndex] = m_4_9_veriRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//Process items population
            	if ( line.compareTo("#START_PROC_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = true; isOutputRem = false;
            		procInderx = 1; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isProcessRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_9_veriRemarks[procInderx][procitemIndex] = m_4_9_veriRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//output items population
            	if ( line.compareTo("#START_OUTPUT_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = false; isOutputRem = true;
            		procInderx = 2; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isOutputRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_9_veriRemarks[procInderx][procitemIndex] = m_4_9_veriRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            }//main while
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void populateRemarksfromFile_4_2_stakRemarks()
	{
		String contentFilepath = ".\\" + INCOSE_REMARKS_FOLDER +  "\\" +  INCOSE_4_2_STAK_REMARKS;
		boolean isInputRem = false; boolean isProcessRem = false; boolean isOutputRem = false;
		
		int procInderx = 0; int procitemIndex = 0; 
		
		try (BufferedReader br = new BufferedReader(new FileReader(contentFilepath))) {
            String line;
            while ((line = br.readLine()) != null) 
            {
            	if ( (line.substring(0, 2)).compareTo("//") == 0  ) //ignore comment
            		continue;
            	
            	if ( line.compareTo("#START_INPUT_PROC") == 0  )
            	{
            		isInputRem = true; isProcessRem = false; isOutputRem = false;
            		procInderx = 0; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( (line.substring(0, 11)).compareTo("#START_VAR:") == 0 &&  isInputRem) 
            	{
            		//line = br.readLine();
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_2_stakRemarks[procInderx][procitemIndex] = m_4_2_stakRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//Process items population
            	if ( line.compareTo("#START_PROC_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = true; isOutputRem = false;
            		procInderx = 1; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( (line.substring(0, 11)).compareTo("#START_VAR:") == 0 &&  isProcessRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_2_stakRemarks[procInderx][procitemIndex] = m_4_2_stakRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//output items population
            	if ( line.compareTo("#START_OUTPUT_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = false; isOutputRem = true;
            		procInderx = 2; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( (line.substring(0, 11)).compareTo("#START_VAR:") == 0 &&  isOutputRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_2_stakRemarks[procInderx][procitemIndex] = m_4_2_stakRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            }//main while
        } catch (IOException e) {
            e.printStackTrace();
        }
	}	
	
	public static void populateRemarksfromFile_4_1_bizAnRemarks()
	{
		//String contentFilepath = "C:\\Users\\bkuppusamy\\eclipse-workspace\\INCOSETraining\\src\\IncoseContent_4_1_bizAnRemarks.balaji";
		String contentFilepath = ".\\" + INCOSE_REMARKS_FOLDER +  "\\" +  INCOSE_4_1_BIZ_AN_REMARKS;
		System.out.println("Application Path : " + new java.io.File("").getAbsolutePath());
       // System.out.println(TellMeMyWorkingDirectory.class.getClassLoader().getResource("").getPath());
		boolean isInputRem = false; boolean isProcessRem = false; boolean isOutputRem = false;
		
		int procInderx = 0; int procitemIndex = 0; 
		
		try (BufferedReader br = new BufferedReader(new FileReader(contentFilepath))) {
            String line;
            while ((line = br.readLine()) != null) 
            {
            	if ( (line.substring(0, 2)).compareTo("//") == 0  ) //ignore comment
            		continue;
            	
            	if ( line.compareTo("#START_INPUT_PROC") == 0  )
            	{
            		isInputRem = true; isProcessRem = false; isOutputRem = false;
            		procInderx = 0; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( (line.substring(0, 11)).compareTo("#START_VAR:") == 0 &&  isInputRem) 
            	{
            		//line = br.readLine();
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_1_bizAnRemarks[procInderx][procitemIndex] = m_4_1_bizAnRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//Process items population
            	if ( line.compareTo("#START_PROC_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = true; isOutputRem = false;
            		procInderx = 1; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( (line.substring(0, 11)).compareTo("#START_VAR:") == 0 &&  isProcessRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_1_bizAnRemarks[procInderx][procitemIndex] = m_4_1_bizAnRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//output items population
            	if ( line.compareTo("#START_OUTPUT_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = false; isOutputRem = true;
            		procInderx = 2; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( (line.substring(0, 11)).compareTo("#START_VAR:") == 0 &&  isOutputRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_4_1_bizAnRemarks[procInderx][procitemIndex] = m_4_1_bizAnRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            }//main while
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private static void populateRemarksfromFile_6_1_agreeRemarks()
	{
		String contentFilepath = ".\\" + INCOSE_REMARKS_FOLDER +  "\\" +  INCOSE_6_1_AGREE_REMARKS;
		
		boolean isInputRem = false; boolean isProcessRem = false; boolean isOutputRem = false;
		
		int procInderx = 0; int procitemIndex = 0; 
		
		try (BufferedReader br = new BufferedReader(new FileReader(contentFilepath))) {
            String line;
            while ((line = br.readLine()) != null) 
            {
            	if ( (line.substring(0, 2)).compareTo("//") == 0  ) //ignore comment
            		continue;
            	
            	if ( line.compareTo("#START_INPUT_PROC") == 0  )
            	{
            		isInputRem = true; isProcessRem = false; isOutputRem = false;
            		procInderx = 0; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isInputRem) 
            	{
            		//line = br.readLine();
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_6_1_agreeRemarks[procInderx][procitemIndex] = m_6_1_agreeRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//Process items population
            	if ( line.compareTo("#START_PROC_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = true; isOutputRem = false;
            		procInderx = 1; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isProcessRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_6_1_agreeRemarks[procInderx][procitemIndex] = m_6_1_agreeRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            	
            	//output items population
            	if ( line.compareTo("#START_OUTPUT_PROC") == 0  )
            	{
            		isInputRem = false; isProcessRem = false; isOutputRem = true;
            		procInderx = 2; procitemIndex = 0; 
            		line = br.readLine();
            	}
            	
            	if ( line.contains("#START_VAR:") == true &&  isOutputRem) 
            	{
            		while ( (line = br.readLine()).contains("#END_VAR:") != true )
            		{
            			m_6_1_agreeRemarks[procInderx][procitemIndex] = m_6_1_agreeRemarks[procInderx][procitemIndex] + line + "\r\n";
            		}
            		procitemIndex = procitemIndex + 1;
            	}
            }//main while
        } catch (IOException e) { e.printStackTrace(); }
	}
		
	@SuppressWarnings("unchecked")
	private void populateIPOList_forproc4_techProc(int selind)
	{
		switch (selind)
		{
		case 0: //4.1
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_1_bizAn_I_1); idlm.addElement(s4_1_bizAn_I_2); idlm.addElement(s4_1_bizAn_I_3); idlm.addElement(s4_1_bizAn_I_4); idlm.addElement(s4_1_bizAn_I_5); idlm.addElement(s4_1_bizAn_I_6);	
			pdlm.addElement(s4_1_bizAn_P_1); pdlm.addElement(s4_1_bizAn_P_2); pdlm.addElement(s4_1_bizAn_P_3); pdlm.addElement(s4_1_bizAn_P_4); pdlm.addElement(s4_1_bizAn_P_5);
			odlm.addElement(s4_1_bizAn_O_1); odlm.addElement(s4_1_bizAn_O_2); odlm.addElement(s4_1_bizAn_O_3); odlm.addElement(s4_1_bizAn_O_4); odlm.addElement(s4_1_bizAn_O_5); odlm.addElement(s4_1_bizAn_O_6); odlm.addElement(s4_1_bizAn_O_7); odlm.addElement(s4_1_bizAn_O_8); odlm.addElement(s4_1_bizAn_O_9); odlm.addElement(s4_1_bizAn_O_10); odlm.addElement(s4_1_bizAn_O_11);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 1: //4.2
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_2_stak_I_1);idlm.addElement(s4_2_stak_I_2);idlm.addElement(s4_2_stak_I_3);idlm.addElement(s4_2_stak_I_4);idlm.addElement(s4_2_stak_I_5);idlm.addElement(s4_2_stak_I_6);idlm.addElement(s4_2_stak_I_7);idlm.addElement(s4_2_stak_I_8);idlm.addElement(s4_2_stak_I_9);idlm.addElement(s4_2_stak_I_10);idlm.addElement(s4_2_stak_I_11);idlm.addElement(s4_2_stak_I_12);idlm.addElement(s4_2_stak_I_13);idlm.addElement(s4_2_stak_I_14);idlm.addElement(s4_2_stak_I_15);
			pdlm.addElement(s4_2_stak_P_1);pdlm.addElement(s4_2_stak_P_2);pdlm.addElement(s4_2_stak_P_3);pdlm.addElement(s4_2_stak_P_4);pdlm.addElement(s4_2_stak_P_5);pdlm.addElement(s4_2_stak_P_6);
			odlm.addElement(s4_2_stak_O_1);odlm.addElement(s4_2_stak_O_2);odlm.addElement(s4_2_stak_O_3);odlm.addElement(s4_2_stak_O_4);odlm.addElement(s4_2_stak_O_5);odlm.addElement(s4_2_stak_O_6);odlm.addElement(s4_2_stak_O_7);odlm.addElement(s4_2_stak_O_8);odlm.addElement(s4_2_stak_O_9);odlm.addElement(s4_2_stak_O_10);
			m_textAreaIPORemarks.setText(s_pro_2_rem);
			break;
		case 2: //4.3
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_3_sysReq_I_1);idlm.addElement(s4_3_sysReq_I_2);idlm.addElement(s4_3_sysReq_I_3);idlm.addElement(s4_3_sysReq_I_4);idlm.addElement(s4_3_sysReq_I_5);idlm.addElement(s4_3_sysReq_I_6);idlm.addElement(s4_3_sysReq_I_7);idlm.addElement(s4_3_sysReq_I_8);
			pdlm.addElement(s4_3_sysReq_P_1);pdlm.addElement(s4_3_sysReq_P_2);pdlm.addElement(s4_3_sysReq_P_3);pdlm.addElement(s4_3_sysReq_P_4);
			odlm.addElement(s4_3_sysReq_O_1);odlm.addElement(s4_3_sysReq_O_2);odlm.addElement(s4_3_sysReq_O_3);odlm.addElement(s4_3_sysReq_O_4);odlm.addElement(s4_3_sysReq_O_5);odlm.addElement(s4_3_sysReq_O_6);odlm.addElement(s4_3_sysReq_O_7);odlm.addElement(s4_3_sysReq_O_8);odlm.addElement(s4_3_sysReq_O_9);odlm.addElement(s4_3_sysReq_O_10);
			m_textAreaIPORemarks.setText(s_pro_3_rem);
			break;
		case 3: //4.4
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_3_sysReq_I_1);
			idlm.addElement(s4_4_arch_I_1);idlm.addElement(s4_4_arch_I_2);idlm.addElement(s4_4_arch_I_3);idlm.addElement(s4_4_arch_I_4);idlm.addElement(s4_4_arch_I_5);idlm.addElement(s4_4_arch_I_6);idlm.addElement(s4_4_arch_I_7);idlm.addElement(s4_4_arch_I_8);idlm.addElement(s4_4_arch_I_9);
			pdlm.addElement(s4_4_arch_P_1);pdlm.addElement(s4_4_arch_P_2);pdlm.addElement(s4_4_arch_P_3);pdlm.addElement(s4_4_arch_P_4);pdlm.addElement(s4_4_arch_P_5);pdlm.addElement(s4_4_arch_P_6);
			odlm.addElement(s4_4_arch_O_1);odlm.addElement(s4_4_arch_O_2);odlm.addElement(s4_4_arch_O_3);odlm.addElement(s4_4_arch_O_4);odlm.addElement(s4_4_arch_O_5);odlm.addElement(s4_4_arch_O_6);odlm.addElement(s4_4_arch_O_7);odlm.addElement(s4_4_arch_O_8);odlm.addElement(s4_4_arch_O_9);
			m_textAreaIPORemarks.setText(s_pro_4_rem);
			break;
		case 4: //4.5
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_5_desig_I_1);idlm.addElement(s4_5_desig_I_2);idlm.addElement(s4_5_desig_I_3);idlm.addElement(s4_5_desig_I_4);idlm.addElement(s4_5_desig_I_5);idlm.addElement(s4_5_desig_I_6);idlm.addElement(s4_5_desig_I_7);idlm.addElement(s4_5_desig_I_8);idlm.addElement(s4_5_desig_I_9);idlm.addElement(s4_5_desig_I_10);idlm.addElement(s4_5_desig_I_11);idlm.addElement(s4_5_desig_I_12);idlm.addElement(s4_5_desig_I_13);
			pdlm.addElement(s4_5_desig_P_1);pdlm.addElement(s4_5_desig_P_2);pdlm.addElement(s4_5_desig_P_3);pdlm.addElement(s4_5_desig_P_4);
			odlm.addElement(s4_5_desig_O_1);odlm.addElement(s4_5_desig_O_2);odlm.addElement(s4_5_desig_O_3);odlm.addElement(s4_5_desig_O_4);odlm.addElement(s4_5_desig_O_5);odlm.addElement(s4_5_desig_O_6);odlm.addElement(s4_5_desig_O_7);odlm.addElement(s4_5_desig_O_8);odlm.addElement(s4_5_desig_O_9);
			m_textAreaIPORemarks.setText(s_pro_5_rem);
			break;
		case 5: //4.6
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_6_SysAn_I_1);idlm.addElement(s4_6_SysAn_I_2);idlm.addElement(s4_6_SysAn_I_3);
			pdlm.addElement(s4_6_SysAn_P_1);pdlm.addElement(s4_6_SysAn_P_2);pdlm.addElement(s4_6_SysAn_P_3);
			odlm.addElement(s4_6_SysAn_O_1);odlm.addElement(s4_6_SysAn_O_2);odlm.addElement(s4_6_SysAn_O_3);
			m_textAreaIPORemarks.setText(s_pro_6_rem);
			break;
		case 6: //4.7
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_7_Impl_I_1);idlm.addElement(s4_7_Impl_I_2);idlm.addElement(s4_7_Impl_I_3);idlm.addElement(s4_7_Impl_I_4);idlm.addElement(s4_7_Impl_I_5);idlm.addElement(s4_7_Impl_I_6);idlm.addElement(s4_7_Impl_I_7);idlm.addElement(s4_7_Impl_I_8);
			pdlm.addElement(s4_7_Impl_P_1);pdlm.addElement(s4_7_Impl_P_2);pdlm.addElement(s4_7_Impl_P_3);
			odlm.addElement(s4_7_Impl_O_1);odlm.addElement(s4_7_Impl_O_2);odlm.addElement(s4_7_Impl_O_3);odlm.addElement(s4_7_Impl_O_4);odlm.addElement(s4_7_Impl_O_5);odlm.addElement(s4_7_Impl_O_6);odlm.addElement(s4_7_Impl_O_7);odlm.addElement(s4_7_Impl_O_8);odlm.addElement(s4_7_Impl_O_9);
			m_textAreaIPORemarks.setText(s_pro_7_rem);
			break;
		case 7: //4.8 integration
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_8_Integ_I_1);idlm.addElement(s4_8_Integ_I_2);idlm.addElement(s4_8_Integ_I_3);idlm.addElement(s4_8_Integ_I_4);idlm.addElement(s4_8_Integ_I_5);idlm.addElement(s4_8_Integ_I_6);idlm.addElement(s4_8_Integ_I_7);
			pdlm.addElement(s4_8_Integ_P_1);pdlm.addElement(s4_8_Integ_P_2);pdlm.addElement(s4_8_Integ_P_3);
			odlm.addElement(s4_8_Integ_O_1);odlm.addElement(s4_8_Integ_O_2);odlm.addElement(s4_8_Integ_O_3);odlm.addElement(s4_8_Integ_O_4);odlm.addElement(s4_8_Integ_O_5);odlm.addElement(s4_8_Integ_O_6);odlm.addElement(s4_8_Integ_O_7);odlm.addElement(s4_8_Integ_O_8);
			m_textAreaIPORemarks.setText(s_pro_8_rem);
			break;
		case 8: //4.9
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_9_Veri_I_1);idlm.addElement(s4_9_Veri_I_2);idlm.addElement(s4_9_Veri_I_3);idlm.addElement(s4_9_Veri_I_4);idlm.addElement(s4_9_Veri_I_5);idlm.addElement(s4_9_Veri_I_6);idlm.addElement(s4_9_Veri_I_7);
			pdlm.addElement(s4_9_Veri_P_1);pdlm.addElement(s4_9_Veri_P_2);pdlm.addElement(s4_9_Veri_P_3);
			odlm.addElement(s4_9_Veri_O_1);odlm.addElement(s4_9_Veri_O_2);odlm.addElement(s4_9_Veri_O_3);odlm.addElement(s4_9_Veri_O_4);odlm.addElement(s4_9_Veri_O_5);odlm.addElement(s4_9_Veri_O_6);odlm.addElement(s4_9_Veri_O_7);odlm.addElement(s4_9_Veri_O_8);
			m_textAreaIPORemarks.setText(s_pro_9_rem);
			break;
		case 9: //4.10
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_10_Tran_I_1);idlm.addElement(s4_10_Tran_I_2);idlm.addElement(s4_10_Tran_I_3);idlm.addElement(s4_10_Tran_I_4);idlm.addElement(s4_10_Tran_I_5);
			pdlm.addElement(s4_10_Tran_P_1);pdlm.addElement(s4_10_Tran_P_2);pdlm.addElement(s4_10_Tran_P_3);
			odlm.addElement(s4_10_Tran_O_1);odlm.addElement(s4_10_Tran_O_2);odlm.addElement(s4_10_Tran_O_3);odlm.addElement(s4_10_Tran_O_4);odlm.addElement(s4_10_Tran_O_5);odlm.addElement(s4_10_Tran_O_6);odlm.addElement(s4_10_Tran_O_7);odlm.addElement(s4_10_Tran_O_8);
			m_textAreaIPORemarks.setText(s_pro_10_rem);
			break;
		case 10: //4.11
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_11_Vali_I_1);idlm.addElement(s4_11_Vali_I_2);idlm.addElement(s4_11_Vali_I_3);idlm.addElement(s4_11_Vali_I_4);idlm.addElement(s4_11_Vali_I_5);idlm.addElement(s4_11_Vali_I_6);
			pdlm.addElement(s4_11_Vali_P_1);pdlm.addElement(s4_11_Vali_P_2);pdlm.addElement(s4_11_Vali_P_3);
			odlm.addElement(s4_11_Vali_O_1);odlm.addElement(s4_11_Vali_O_2);odlm.addElement(s4_11_Vali_O_3);odlm.addElement(s4_11_Vali_O_4);
			m_textAreaIPORemarks.setText(s_pro_11_rem);
			break;
		case 11: //4.12
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_12_Oper_I_1);idlm.addElement(s4_12_Oper_I_2);idlm.addElement(s4_12_Oper_I_3);idlm.addElement(s4_12_Oper_I_4);idlm.addElement(s4_12_Oper_I_5);idlm.addElement(s4_12_Oper_I_6);
			pdlm.addElement(s4_12_Oper_P_1);pdlm.addElement(s4_12_Oper_P_2);pdlm.addElement(s4_12_Oper_P_3);pdlm.addElement(s4_12_Oper_P_4);
			odlm.addElement(s4_12_Oper_O_1);odlm.addElement(s4_12_Oper_O_2);odlm.addElement(s4_12_Oper_O_3);odlm.addElement(s4_12_Oper_O_4);odlm.addElement(s4_12_Oper_O_5);
			m_textAreaIPORemarks.setText(s_pro_12_rem);
			break;
		case 12: //4.13
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_13_Main_I_1);idlm.addElement(s4_13_Main_I_2);idlm.addElement(s4_13_Main_I_3);idlm.addElement(s4_13_Main_I_4);idlm.addElement(s4_13_Main_I_5);idlm.addElement(s4_13_Main_I_6);
			pdlm.addElement(s4_13_Main_P_1);pdlm.addElement(s4_13_Main_P_2);pdlm.addElement(s4_13_Main_P_3);pdlm.addElement(s4_13_Main_P_4);
			odlm.addElement(s4_13_Main_O_1);odlm.addElement(s4_13_Main_O_2);odlm.addElement(s4_13_Main_O_3);odlm.addElement(s4_13_Main_O_4);odlm.addElement(s4_13_Main_O_5);odlm.addElement(s4_13_Main_O_6);
			m_textAreaIPORemarks.setText(s_pro_13_rem);
			break;
		case 13: //4.14
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s4_14_Disp_I_1);idlm.addElement(s4_14_Disp_I_2);idlm.addElement(s4_14_Disp_I_3);idlm.addElement(s4_14_Disp_I_4);
			pdlm.addElement(s4_14_Disp_P_1);pdlm.addElement(s4_14_Disp_P_2);pdlm.addElement(s4_14_Disp_P_3);
			odlm.addElement(s4_14_Disp_O_1);odlm.addElement(s4_14_Disp_O_2);odlm.addElement(s4_14_Disp_O_3);odlm.addElement(s4_14_Disp_O_4);odlm.addElement(s4_14_Disp_O_5);odlm.addElement(s4_14_Disp_O_6);odlm.addElement(s4_14_Disp_O_7);
			m_textAreaIPORemarks.setText(s_pro_14_rem);
			break;
		default: System.err.println("populateIPOList_forproc4_techProc::whoops! sw! ");
		}//proc 4.
	}
	
	@SuppressWarnings("unchecked")
	private void populateIPOList_forproc5_techManagProc(int selind)
	{
		switch (selind)
		{
		case 0: //5.1
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_1_techManPro_I_1);idlm.addElement(s5_1_techManPro_I_2);idlm.addElement(s5_1_techManPro_I_3);idlm.addElement(s5_1_techManPro_I_4);idlm.addElement(s5_1_techManPro_I_5);idlm.addElement(s5_1_techManPro_I_6);idlm.addElement(s5_1_techManPro_I_7);idlm.addElement(s5_1_techManPro_I_8);idlm.addElement(s5_1_techManPro_I_9);idlm.addElement(s5_1_techManPro_I_10);idlm.addElement(s5_1_techManPro_I_11);idlm.addElement(s5_1_techManPro_I_12);idlm.addElement(s5_1_techManPro_I_13); 	
			pdlm.addElement(s5_1_techManPro_P_1);pdlm.addElement(s5_1_techManPro_P_2);pdlm.addElement(s5_1_techManPro_P_3);
			odlm.addElement(s5_1_techManPro_O_1);odlm.addElement(s5_1_techManPro_O_2);odlm.addElement(s5_1_techManPro_O_3);odlm.addElement(s5_1_techManPro_O_4);odlm.addElement(s5_1_techManPro_O_5);odlm.addElement(s5_1_techManPro_O_6);odlm.addElement(s5_1_techManPro_O_7);odlm.addElement(s5_1_techManPro_O_8);odlm.addElement(s5_1_techManPro_O_9); 
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 1: //5.2
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_2_projAssCtrl_I_1); idlm.addElement(s5_2_projAssCtrl_I_2); idlm.addElement(s5_2_projAssCtrl_I_3); idlm.addElement(s5_2_projAssCtrl_I_4); idlm.addElement(s5_2_projAssCtrl_I_5); idlm.addElement(s5_2_projAssCtrl_I_6);idlm.addElement(s5_2_projAssCtrl_I_7);idlm.addElement(s5_2_projAssCtrl_I_8);idlm.addElement(s5_2_projAssCtrl_I_9);idlm.addElement(s5_2_projAssCtrl_I_10);idlm.addElement(s5_2_projAssCtrl_I_11);
			pdlm.addElement(s5_2_projAssCtrl_P_1); pdlm.addElement(s5_2_projAssCtrl_P_2); pdlm.addElement(s5_2_projAssCtrl_P_3); 
			odlm.addElement(s5_2_projAssCtrl_O_1);odlm.addElement(s5_2_projAssCtrl_O_2);odlm.addElement(s5_2_projAssCtrl_O_3);odlm.addElement(s5_2_projAssCtrl_O_4);odlm.addElement(s5_2_projAssCtrl_O_5);odlm.addElement(s5_2_projAssCtrl_O_6);odlm.addElement(s5_2_projAssCtrl_O_7);odlm.addElement(s5_2_projAssCtrl_O_8);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 2: //5.3
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_3_DeciManPro_I_1);
			pdlm.addElement(s5_3_DeciManPro_P_1);pdlm.addElement(s5_3_DeciManPro_P_2);pdlm.addElement(s5_3_DeciManPro_P_3);
			odlm.addElement(s5_3_DeciManPro_O_1);odlm.addElement(s5_3_DeciManPro_O_2);odlm.addElement(s5_3_DeciManPro_O_3);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 3: //5.4
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_4_RiskMan_I_1);
			pdlm.addElement(s5_4_RiskMan_P_1);pdlm.addElement(s5_4_RiskMan_P_2);pdlm.addElement(s5_4_RiskMan_P_3);pdlm.addElement(s5_4_RiskMan_P_4);pdlm.addElement(s5_4_RiskMan_P_5);
			odlm.addElement(s5_4_RiskMan_O_1);odlm.addElement(s5_4_RiskMan_O_2);odlm.addElement(s5_4_RiskMan_O_3);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 4: //5.5 todo bk update
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_5_ConfigMan_I_1);idlm.addElement(s5_5_ConfigMan_I_2);
			pdlm.addElement(s5_5_ConfigMan_P_1);pdlm.addElement(s5_5_ConfigMan_P_2);pdlm.addElement(s5_5_ConfigMan_P_3);pdlm.addElement(s5_5_ConfigMan_P_4);pdlm.addElement(s5_5_ConfigMan_P_5);pdlm.addElement(s5_5_ConfigMan_P_6);
			odlm.addElement(s5_5_ConfigMan_O_1);odlm.addElement(s5_5_ConfigMan_O_2);odlm.addElement(s5_5_ConfigMan_O_3);odlm.addElement(s5_5_ConfigMan_O_4);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 5: //5.6 todo bk update
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_6_InfoMan_I_1);idlm.addElement(s5_6_InfoMan_I_2);
			pdlm.addElement(s5_6_InfoMan_P_1);pdlm.addElement(s5_6_InfoMan_P_2);
			odlm.addElement(s5_6_InfoMan_O_1);odlm.addElement(s5_6_InfoMan_O_2);odlm.addElement(s5_6_InfoMan_O_3);odlm.addElement(s5_6_InfoMan_O_4);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 6: //5.7 todo bk update
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_7_MeasMan_I_1);idlm.addElement(s5_7_MeasMan_I_2);
			pdlm.addElement(s5_7_MeasMan_P_1);pdlm.addElement(s5_7_MeasMan_P_2);
			odlm.addElement(s5_7_MeasMan_O_1);odlm.addElement(s5_7_MeasMan_O_2);odlm.addElement(s5_7_MeasMan_O_3);odlm.addElement(s5_7_MeasMan_O_4);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		case 7: //5.8
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s5_8_QualMan_I_1);idlm.addElement(s5_8_QualMan_I_2);idlm.addElement(s5_8_QualMan_I_3);idlm.addElement(s5_8_QualMan_I_4);
			pdlm.addElement(s5_8_QualMan_P_1);pdlm.addElement(s5_8_QualMan_P_2);pdlm.addElement(s5_8_QualMan_P_3);pdlm.addElement(s5_8_QualMan_P_4);pdlm.addElement(s5_8_QualMan_P_5);
			odlm.addElement(s5_8_QualMan_O_1);odlm.addElement(s5_8_QualMan_O_2);odlm.addElement(s5_8_QualMan_O_3);odlm.addElement(s5_8_QualMan_O_4);
			m_textAreaIPORemarks.setText(s_pro_1_rem);
			break;
		default: System.err.println("populateIPOList_forproc5_techManagProc::whoops! sw! ");
		}//proc 5.
	}
	
	@SuppressWarnings("unchecked")
	private void populateIPOList_forproc6_agree(int selind)
	{
		switch (selind)
		{
		case 0: //6.1
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s6_1_Agree_I_1); idlm.addElement(s6_1_Agree_I_2); idlm.addElement(s6_1_Agree_I_3); idlm.addElement(s6_1_Agree_I_4); idlm.addElement(s6_1_Agree_I_5);	
			pdlm.addElement(s6_1_Agree_P_1); pdlm.addElement(s6_1_Agree_P_2); pdlm.addElement(s6_1_Agree_P_3); pdlm.addElement(s6_1_Agree_P_4); pdlm.addElement(s6_1_Agree_P_5);
			odlm.addElement(s6_1_Agree_O_1); odlm.addElement(s6_1_Agree_O_2); odlm.addElement(s6_1_Agree_O_3); odlm.addElement(s6_1_Agree_O_4); odlm.addElement(s6_1_Agree_O_5); odlm.addElement(s6_1_Agree_O_6); odlm.addElement(s6_1_Agree_O_7);
			m_textAreaIPORemarks.setText("test 6.1");
			break;
		case 1: //6.2
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s6_2_Agree_I_1); idlm.addElement(s6_2_Agree_I_2); idlm.addElement(s6_2_Agree_I_3); idlm.addElement(s6_2_Agree_I_4); idlm.addElement(s6_2_Agree_I_5);	
			pdlm.addElement(s6_2_Agree_P_1); pdlm.addElement(s6_2_Agree_P_2); pdlm.addElement(s6_2_Agree_P_3); pdlm.addElement(s6_2_Agree_P_4); pdlm.addElement(s6_2_Agree_P_5);
			odlm.addElement(s6_2_Agree_O_1); odlm.addElement(s6_2_Agree_O_2); odlm.addElement(s6_2_Agree_O_3); odlm.addElement(s6_2_Agree_O_4); odlm.addElement(s6_2_Agree_O_5); odlm.addElement(s6_2_Agree_O_6);
			m_textAreaIPORemarks.setText("test 6.2");
			break;
		default: System.err.println("populateIPOList_forproc6_agree: whoops! sw! ");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void populateIPOList_forproc7_OrgProjEnab(int selind)
	{
		switch (selind)
		{
		case 0: //7.1
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s7_1_LifCycMod_I_1);idlm.addElement(s7_1_LifCycMod_I_2);idlm.addElement(s7_1_LifCycMod_I_3);idlm.addElement(s7_1_LifCycMod_I_4);
			pdlm.addElement(s7_1_LifCycMod_P_1);pdlm.addElement(s7_1_LifCycMod_P_2);pdlm.addElement(s7_1_LifCycMod_P_3);
			odlm.addElement(s7_1_LifCycMod_O_1);odlm.addElement(s7_1_LifCycMod_O_2);odlm.addElement(s7_1_LifCycMod_O_3);odlm.addElement(s7_1_LifCycMod_O_4);odlm.addElement(s7_1_LifCycMod_O_5);odlm.addElement(s7_1_LifCycMod_O_6);odlm.addElement(s7_1_LifCycMod_O_7);
			m_textAreaIPORemarks.setText("test 7.1");
			break;
		case 1: //7.2
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s7_2_InfrMan_I_1);idlm.addElement(s7_2_InfrMan_I_2);idlm.addElement(s7_2_InfrMan_I_3);
			pdlm.addElement(s7_2_InfrMan_P_1);pdlm.addElement(s7_2_InfrMan_P_2);
			odlm.addElement(s7_2_InfrMan_O_1);odlm.addElement(s7_2_InfrMan_O_2);odlm.addElement(s7_2_InfrMan_O_3);odlm.addElement(s7_2_InfrMan_O_4);odlm.addElement(s7_2_InfrMan_O_5);
			m_textAreaIPORemarks.setText("test 7.2");
			break;
		case 2: //7.3
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s7_3_PortfoMan_I_1);idlm.addElement(s7_3_PortfoMan_I_2);idlm.addElement(s7_3_PortfoMan_I_3);idlm.addElement(s7_3_PortfoMan_I_4);
			pdlm.addElement(s7_3_PortfoMan_P_1);pdlm.addElement(s7_3_PortfoMan_P_2);pdlm.addElement(s7_3_PortfoMan_P_3);
			odlm.addElement(s7_3_PortfoMan_O_1);odlm.addElement(s7_3_PortfoMan_O_2);odlm.addElement(s7_3_PortfoMan_O_3);odlm.addElement(s7_3_PortfoMan_O_4);odlm.addElement(s7_3_PortfoMan_O_5);odlm.addElement(s7_3_PortfoMan_O_6);odlm.addElement(s7_3_PortfoMan_O_7);
			m_textAreaIPORemarks.setText("test 7.3");
			break;
		case 3: //7.4
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s7_4_HR_I_1);idlm.addElement(s7_4_HR_I_2);idlm.addElement(s7_4_HR_I_3);
			pdlm.addElement(s7_4_HR_P_1);pdlm.addElement(s7_4_HR_P_2);pdlm.addElement(s7_4_HR_P_3);
			odlm.addElement(s7_4_HR_O_1);odlm.addElement(s7_4_HR_O_2);odlm.addElement(s7_4_HR_O_3);odlm.addElement(s7_4_HR_O_4);
			m_textAreaIPORemarks.setText("test 7.4");
			break;
		case 4: //7.5
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s7_5_QualMan_I_1);idlm.addElement(s7_5_QualMan_I_2);idlm.addElement(s7_5_QualMan_I_3);idlm.addElement(s7_5_QualMan_I_4);idlm.addElement(s7_5_QualMan_I_5);
			pdlm.addElement(s7_5_QualMan_P_1);pdlm.addElement(s7_5_QualMan_P_2);pdlm.addElement(s7_5_QualMan_P_3);pdlm.addElement(s7_5_QualMan_P_4);
			odlm.addElement(s7_5_QualMan_O_1);odlm.addElement(s7_5_QualMan_O_2);odlm.addElement(s7_5_QualMan_O_3);odlm.addElement(s7_5_QualMan_O_4);odlm.addElement(s7_5_QualMan_O_5);odlm.addElement(s7_5_QualMan_O_6);
			m_textAreaIPORemarks.setText("test 7.5");
			break;
		case 5: //7.6
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s7_6_KnowMan_I_1);idlm.addElement(s7_6_KnowMan_I_2);idlm.addElement(s7_6_KnowMan_I_3);
			pdlm.addElement(s7_6_KnowMan_P_1);pdlm.addElement(s7_6_KnowMan_P_2);pdlm.addElement(s7_6_KnowMan_P_3);pdlm.addElement(s7_6_KnowMan_P_4);
			odlm.addElement(s7_6_KnowMan_O_1);odlm.addElement(s7_6_KnowMan_O_2);odlm.addElement(s7_6_KnowMan_O_3);
			m_textAreaIPORemarks.setText("test 7.6");
			break;
		default: System.err.println("populateIPOList_forproc7_OrgProjEnab: whoops! sw! ");
		}
	}	
		
	@SuppressWarnings("unchecked")
	private void populateIPOList_forproc8_TailProc(int selind)
	{
		switch (selind)
		{
		case 0: //8.1
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			idlm.addElement(s8_1_TailProc_I_1);idlm.addElement(s8_1_TailProc_I_2);
			pdlm.addElement(s8_1_TailProc_P_1);pdlm.addElement(s8_1_TailProc_P_2);pdlm.addElement(s8_1_TailProc_P_3);pdlm.addElement(s8_1_TailProc_P_4);pdlm.addElement(s8_1_TailProc_P_5);
			odlm.addElement(s8_1_TailProc_O_1);odlm.addElement(s8_1_TailProc_O_2);
			m_textAreaIPORemarks.setText("test 8.1");
			break;
		case 1: //8.2 No IPO to populate for this process
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("for 8.2 TAILORING FOR SPECIFIC PRODUCT SECTOR OR DOMAIN APPLICATION process there is no IPO. "
					+ "This process describes in general\r\n" + 
					"how this SE process applied to any SIZE and any SYSTEM in any DOMAIN. e.g. Biomedical, Healthcare, "
					+ "Defense, Aerospace, Space, Infrastrucutre, Transportations systems.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 2: //8.3
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("8.3: for this SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 3: //8.4
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("8.4: for this SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 4: //8.5
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("8.5: for this SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 5: //8.6
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("8.6: for this SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		default: System.err.println("populateIPOList_forproc8_TailProc: whoops! sw! ");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void populateIPOList_forproc9_CrossCutSE(int selind)
	{
		switch (selind)
		{
		case 0: //9.1
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.1: for MODELING AND SIMULATION SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 1: //9.2 No IPO to populate for this process
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.2: for MODEL BASED SYSTEMS ENGINEERING there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 2: //9.3
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.3: for FUNCTIONS BASED SYSTEMS ENGINEERING METHOD this SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 3: //9.4
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.4: for OBJECT ORIENTED SYSTEMS ENGINEERING METHOD SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 4: //9.5
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.5: for PROTOTYPING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 5: //9.6
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.6: for INTERFACE MANAGEMENT SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 6: //9.7
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.7: for INTEGRATED PRODUCT AND PROCESS DEVELOPMENT SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 7: //9.8
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.8: for LEAN SYSTEMS ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 8: //9.9
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("9.9: for AGILE SYSTEMS ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		default: System.err.println("populateIPOList_forproc9_CrossCutSE: whoops! sw! ");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void populateIPOList_forproc10_SpecialEngg(int selind)
	{
		switch (selind)
		{
		case 0: //10.1
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.1: for AFFORDABILITY COST EFFECTIVENESS LIFE CYCLE COST ANALYSIS SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 1: //10.2 
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.2: for ELECTROMAGNETIC COMPATIBILITY SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 2: //10.3
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.3: for ENVIRONMENTAL ENGINEERING IMPACT ANALYSIS SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 3: //10.4
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.4: for INTEROPERABILITY ANALYSIS SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 4: //10.5
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.5: for LOGISTICS ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 5: //10.6
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.6: for MANUFACTURING AND PRODUCIBILITY ANALYSIS SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 6: //10.7
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.7: for MASS PROPERTIES ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 7: //10.8
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.8: for RELIABILITY, AVAILABILITY, AND MAINTAINABILITY SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 8: //10.9
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.9: for RESILIENCE ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 9: //10.10
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.10: for SYSTEM SAFETY ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 10: //10.11
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.11: for SYSTEM SECURITY ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 11: //10.12
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.12: for TRAINING NEEDS ANALYSIS SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 12: //10.13
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.13: for USABILITY ANALYSIS HUMAN SYSTEMS INTEGRATION SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		case 13: //10.14
			idlm.clear(); pdlm.clear(); odlm.clear(); m_textAreaIPORemarks.setText("");
			m_textAreaIPORemarks.setText("10.14: for VALUE ENGINEERING SE process there is no IPO.");
			idlm.addElement("NA"); pdlm.addElement("NA"); odlm.addElement("NA");
			break;
		default: System.err.println("populateIPOList_forproc10_SpecialEngg: whoops! sw! ");
		}
	}
	
	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public INCOSEgui() {
		setTitle("INCOSE Training Tool");
		setBounds(100, 100, 982, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			lblSelectASe = new JLabel("Select a Detailed Process : ");
			lblSelectASe.setToolTipText("Select a Process to learn more on the topic");
		}
		{
			String[] strListSEProcess = {s_pro_4_1,s_pro_4_2,s_pro_4_3,s_pro_4_4,s_pro_4_5,s_pro_4_6,s_pro_4_7,s_pro_4_8,s_pro_4_9,s_pro_4_10,s_pro_4_11,s_pro_4_12,s_pro_4_13,s_pro_4_14 };
			m_comboBoxSEProcess = new JComboBox(strListSEProcess);
			m_comboBoxSEProcess.setToolTipText("Select a Process to learn");
			m_comboBoxSEProcess.addActionListener(new ActionListener() {
				@SuppressWarnings({ })
				public void actionPerformed(ActionEvent ae) {
					
					String sitem = (String)m_comboBoxSEProcess.getSelectedItem();
					m_iSubProcessindex = m_comboBoxSEProcess.getSelectedIndex();
					m_iMainProcessSelIndex = m_comboBoxMainSE.getSelectedIndex();
					switch (m_iMainProcessSelIndex)
					{
					case 0: //4 tech process
						populateIPOList_forproc4_techProc(m_iSubProcessindex);
						break;
					case 1: //5 tech mgnt process
						populateIPOList_forproc5_techManagProc(m_iSubProcessindex);
						break;
					case 2: //6 agreemtn process
						populateIPOList_forproc6_agree(m_iSubProcessindex);
						break;
					case 3: //7 org proj enebale process
						populateIPOList_forproc7_OrgProjEnab(m_iSubProcessindex);
						break;
					case 4: //8 tailoring process
						populateIPOList_forproc8_TailProc(m_iSubProcessindex);
						break;
					case 5: //9 cross cutting se process
						populateIPOList_forproc9_CrossCutSE(m_iSubProcessindex);
						break;
					case 6: //10 speciality engg  process
						populateIPOList_forproc10_SpecialEngg(m_iSubProcessindex);
						break;
					default: System.err.println("INCOSEgui: whoops! sw! ");
					}					
				}
			});
			m_comboBoxSEProcess.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					m_iSubProcessindex = m_comboBoxSEProcess.getSelectedIndex();
				}
			});
		}
		{
			lblSelectedProcessIpo = new JLabel("Selected Process IPO");
		}
		{
			lblInput = new JLabel("Input :");
			lblInput.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			lblProcess = new JLabel("Process :");
			lblProcess.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			lblOutput = new JLabel("Output :");
			lblOutput.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		{
			lblRemarks = new JLabel("Remarks");
			lblRemarks.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		scrollPane = new JScrollPane();
		scrollPane_1 = new JScrollPane();
		scrollPane_2 = new JScrollPane();
		scrollPane_3 = new JScrollPane();
		
		JLabel lblSelectASe_1 = new JLabel("Select a SE Process :");
		
		m_comboBoxMainSE = new JComboBox();
	
		String[] strListMainSEProcess = {s_mainpro_4,s_mainpro_5,s_mainpro_6,s_mainpro_7,s_mainpro_8,s_mainpro_9,s_mainpro_10 };
		m_comboBoxMainSE = new JComboBox(strListMainSEProcess);
		m_comboBoxMainSE.setToolTipText("Select a Main Process List all sub Processes.");
		
		m_comboBoxMainSE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sitem = (String)m_comboBoxMainSE.getSelectedItem();
				m_iMainProcessSelIndex = m_comboBoxMainSE.getSelectedIndex();
				switch (m_iMainProcessSelIndex)
				{
				case 0: //4 tech proc
					//System.out.println(sitem);
					m_comboBoxSEProcess.removeAllItems();
					m_comboBoxSEProcess.addItem(s_pro_4_1);m_comboBoxSEProcess.addItem(s_pro_4_2);m_comboBoxSEProcess.addItem(s_pro_4_3);m_comboBoxSEProcess.addItem(s_pro_4_4);m_comboBoxSEProcess.addItem(s_pro_4_5);m_comboBoxSEProcess.addItem(s_pro_4_6);m_comboBoxSEProcess.addItem(s_pro_4_7);m_comboBoxSEProcess.addItem(s_pro_4_8);
					m_comboBoxSEProcess.addItem(s_pro_4_9);m_comboBoxSEProcess.addItem(s_pro_4_10);m_comboBoxSEProcess.addItem(s_pro_4_11);m_comboBoxSEProcess.addItem(s_pro_4_12);m_comboBoxSEProcess.addItem(s_pro_4_13);m_comboBoxSEProcess.addItem(s_pro_4_14);
					break;
				case 1: //5 Technical Management Processes
					m_comboBoxSEProcess.removeAllItems();
					m_comboBoxSEProcess.addItem(s_pro_5_1);m_comboBoxSEProcess.addItem(s_pro_5_2);m_comboBoxSEProcess.addItem(s_pro_5_3);m_comboBoxSEProcess.addItem(s_pro_5_4);m_comboBoxSEProcess.addItem(s_pro_5_5);m_comboBoxSEProcess.addItem(s_pro_5_6);m_comboBoxSEProcess.addItem(s_pro_5_7);m_comboBoxSEProcess.addItem(s_pro_5_8);
					break;
				case 2: //6 Agreement Processes
					m_comboBoxSEProcess.removeAllItems();
					m_comboBoxSEProcess.addItem(s_pro_6_1);m_comboBoxSEProcess.addItem(s_pro_6_2);
					break;
				case 3: //7 Organizational Project Enabling Processes
					m_comboBoxSEProcess.removeAllItems();
					m_comboBoxSEProcess.addItem(s_pro_7_1);m_comboBoxSEProcess.addItem(s_pro_7_2);m_comboBoxSEProcess.addItem(s_pro_7_3);m_comboBoxSEProcess.addItem(s_pro_7_4);m_comboBoxSEProcess.addItem(s_pro_7_5);m_comboBoxSEProcess.addItem(s_pro_7_6);
					break;
				case 4: //8 Tailoring process
					m_comboBoxSEProcess.removeAllItems();
					m_comboBoxSEProcess.addItem(s_pro_8_1);m_comboBoxSEProcess.addItem(s_pro_8_2);m_comboBoxSEProcess.addItem(s_pro_8_3);m_comboBoxSEProcess.addItem(s_pro_8_4);m_comboBoxSEProcess.addItem(s_pro_8_5);m_comboBoxSEProcess.addItem(s_pro_8_6);
					break;
				case 5: //9 cross cutting 
					m_comboBoxSEProcess.removeAllItems();
					m_comboBoxSEProcess.addItem(s_pro_9_1);m_comboBoxSEProcess.addItem(s_pro_9_2);m_comboBoxSEProcess.addItem(s_pro_9_3);m_comboBoxSEProcess.addItem(s_pro_9_4);m_comboBoxSEProcess.addItem(s_pro_9_5);m_comboBoxSEProcess.addItem(s_pro_9_6);m_comboBoxSEProcess.addItem(s_pro_9_7);m_comboBoxSEProcess.addItem(s_pro_9_8);m_comboBoxSEProcess.addItem(s_pro_9_9);
					break;
				case 6: //10 speciality engg
					m_comboBoxSEProcess.removeAllItems();
					m_comboBoxSEProcess.addItem(s_pro_10_1);m_comboBoxSEProcess.addItem(s_pro_10_2);m_comboBoxSEProcess.addItem(s_pro_10_3);m_comboBoxSEProcess.addItem(s_pro_10_4);m_comboBoxSEProcess.addItem(s_pro_10_5);m_comboBoxSEProcess.addItem(s_pro_10_6);m_comboBoxSEProcess.addItem(s_pro_10_7);m_comboBoxSEProcess.addItem(s_pro_10_8);m_comboBoxSEProcess.addItem(s_pro_10_9);m_comboBoxSEProcess.addItem(s_pro_10_10);m_comboBoxSEProcess.addItem(s_pro_10_11);m_comboBoxSEProcess.addItem(s_pro_10_12);m_comboBoxSEProcess.addItem(s_pro_10_13);m_comboBoxSEProcess.addItem(s_pro_10_14);
					break;
				default: System.err.println("m_comboBoxMainSE: action: whoops! sw! ");
				}
				//balaji
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblInput))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(374)
							.addComponent(lblRemarks))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProcess))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOutput)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(79)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(144, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addComponent(lblSelectASe_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_comboBoxMainSE, 0, 315, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSelectASe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_comboBoxSEProcess, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(344)
					.addComponent(lblSelectedProcessIpo)
					.addContainerGap(510, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectASe)
						.addComponent(m_comboBoxSEProcess, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectASe_1)
						.addComponent(m_comboBoxMainSE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(lblSelectedProcessIpo)
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblInput)
							.addComponent(lblProcess))
						.addComponent(lblOutput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addComponent(lblRemarks)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		{
			m_textAreaIPORemarks = new JTextArea();
			scrollPane_3.setViewportView(m_textAreaIPORemarks);
			m_textAreaIPORemarks.setToolTipText("Gives tips for the selected IPO items.");
			m_textAreaIPORemarks.setEditable(false);
		}
		{
			m_listOutput = new JList(odlm);
			m_listOutput.setToolTipText("Output of the process after applying tools and techniques on input");
			scrollPane_2.setViewportView(m_listOutput);
			m_listOutput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			m_listOutput.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // ************************************************************ Output process list item selected
					m_listInput.clearSelection();m_listProcess.clearSelection();//clear others
					m_textAreaIPORemarks.setText((String) m_listOutput.getSelectedValue()); m_textAreaIPORemarks.append(":=>> \r\n");
					int ctSelInd = m_listOutput.getSelectedIndex();
					
					switch (m_iMainProcessSelIndex)
					{
						case 0: //4 tech process
						{
							switch (m_iSubProcessindex)
							{
							case 0: //biz analysis
								m_textAreaIPORemarks.append( m_4_1_bizAnRemarks[2][ctSelInd] );
								break;
							case 1: //stakeholder
								m_textAreaIPORemarks.append( m_4_2_stakRemarks[2][ctSelInd] );
								break;
							case 7: //integration
								m_textAreaIPORemarks.append( m_4_8_integRemarks[2][ctSelInd] );
								break;
							case 8: //verification
								m_textAreaIPORemarks.append( m_4_9_veriRemarks[2][ctSelInd] );
								break;
							}
							break;
						}//4 tech process
					case 1: //5 tech mgnt process

						break;
					case 2: //6 agree process
					{
						switch (m_iSubProcessindex)
						{
						case 0: //
							m_textAreaIPORemarks.append( m_6_1_agreeRemarks[2][ctSelInd] );
							break;
						case 1: //
							m_textAreaIPORemarks.append( m_6_1_agreeRemarks[2][ctSelInd] ); //TODO: update
							break;
						}
					}
					break;
					}// m_iMainProcessSelIndex---main process
				}
			});
		}
		{
			m_listProcess = new JList(pdlm);
			m_listProcess.setToolTipText("Activites, tools and techniques of a process");
			scrollPane_1.setViewportView(m_listProcess);
			m_listProcess.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			m_listProcess.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					m_listInput.clearSelection();m_listOutput.clearSelection();//clear others
					m_textAreaIPORemarks.setText((String) m_listProcess.getSelectedValue());m_textAreaIPORemarks.append(":=>> \r\n");
					int ctSelInd = m_listProcess.getSelectedIndex();
								
					switch (m_iMainProcessSelIndex)
					{
						case 0: //4 tech process
						{
							switch (m_iSubProcessindex)
							{
							case 0: //biz analysis
								m_textAreaIPORemarks.append( m_4_1_bizAnRemarks[1][ctSelInd] );
								break;
							case 1: //stakeholder
								m_textAreaIPORemarks.append( m_4_2_stakRemarks[1][ctSelInd] );
								break;
							case 7: //integration
								m_textAreaIPORemarks.append( m_4_8_integRemarks[1][ctSelInd] );
								break;
							case 8: //verification
								m_textAreaIPORemarks.append( m_4_9_veriRemarks[1][ctSelInd] );
								break;
							}
							break;
						}////4 tech process						
					case 1: //5 tech mgnt process

						break;
					case 2: //6 agree process
					{
						switch (m_iSubProcessindex)
						{
						case 0: //
							m_textAreaIPORemarks.append( m_6_1_agreeRemarks[1][ctSelInd] );
							break;
						case 1: //
							m_textAreaIPORemarks.append( m_6_1_agreeRemarks[1][ctSelInd] ); //TODO: update
							break;
						}
					}
					break;
					}// m_iMainProcessSelIndex
				}
			});
		}
		{
			m_listInput = new JList(idlm);
			m_listInput.setToolTipText("Input required for a specific Process");
			scrollPane.setViewportView(m_listInput);
			m_listInput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			m_listInput.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					m_listOutput.clearSelection();m_listProcess.clearSelection(); //clear others
					m_textAreaIPORemarks.setText((String) m_listInput.getSelectedValue());	m_textAreaIPORemarks.append(":=>> \r\n"); 
					
					int ctSelInd = m_listInput.getSelectedIndex();
					
					switch (m_iMainProcessSelIndex)
					{
						case 0: //4 tech process
						{
							switch (m_iSubProcessindex)
							{
							case 0: //biz analysis
								m_textAreaIPORemarks.append( m_4_1_bizAnRemarks[0][ctSelInd] );
								break;
							case 1: //stakeholder
								m_textAreaIPORemarks.append( m_4_2_stakRemarks[0][ctSelInd] );
								break;
							case 7: //integration
								m_textAreaIPORemarks.append( m_4_8_integRemarks[0][ctSelInd] );
								break;
							case 8: //verification
								m_textAreaIPORemarks.append( m_4_9_veriRemarks[0][ctSelInd] );
								break;							
							}
						}
						break;
						case 2: //6 agree process
						{
							switch (m_iSubProcessindex)
							{
							case 0: //
								m_textAreaIPORemarks.append( m_6_1_agreeRemarks[0][ctSelInd] );
								break;
							case 1: //
								m_textAreaIPORemarks.append( m_6_1_agreeRemarks[0][ctSelInd] ); //TODO: update
								break;
							}
						}
						break;
					}//m_iMainProcessSelIndex
				}
			});
		}
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//close application
						System.out.println("Bye!");
						System.exit(0);
					}
				});
				
				JButton btnNewButton = new JButton("Help");
				buttonPane.add(btnNewButton);
				cancelButton.setToolTipText("Close Application");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
