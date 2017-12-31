var ScalaMeter = (function(parent) {
  var my = { name: "data" };
  my.index = [{"scope" : ["IntervalTree", "update"], "name" : "Test-0", "file" : "..\/IntervalTree.update.Test-0.dsv"}, {"scope" : ["IntervalTree", "sorted"], "name" : "Test-1", "file" : "..\/IntervalTree.sorted.Test-1.dsv"}, {"scope" : ["IntervalTree", "skipped"], "name" : "Test-2", "file" : "..\/IntervalTree.skipped.Test-2.dsv"}, {"scope" : ["Intervals", "update"], "name" : "Test-3", "file" : "..\/Intervals.update.Test-3.dsv"}, {"scope" : ["Intervals", "sorted"], "name" : "Test-4", "file" : "..\/Intervals.sorted.Test-4.dsv"}, {"scope" : ["Intervals", "skipped"], "name" : "Test-5", "file" : "..\/Intervals.skipped.Test-5.dsv"}, {"scope" : ["Ranges", "update"], "name" : "Test-6", "file" : "..\/Ranges.update.Test-6.dsv"}, {"scope" : ["Ranges", "sorted"], "name" : "Test-7", "file" : "..\/Ranges.sorted.Test-7.dsv"}, {"scope" : ["Ranges", "skipped"], "name" : "Test-8", "file" : "..\/Ranges.skipped.Test-8.dsv"}];
  my.tsvData = ['date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.04856208333333333	true	0.028	0.069	ms	"0.010318 0.035098 0.079385 0.080679 0.010944 0.034923 0.041122 0.088837 0.059431 0.064058 0.069336 0.077249 0.047501 0.062678 0.062836 0.067929 0.032711 0.033241 0.035769 0.039215 0.031948 0.03244 0.03484 0.039482 0.062655 0.064721 0.067421 0.068297 0.035332 0.036655 0.040058 0.045072 0.034927 0.035242 0.039688 0.046197"\n2017-12-31T01:17:54Z	300	0.08071280555555554	true	0.049	0.112	ms	"0.061562 0.065222 0.066073 0.075331 0.067868 0.068165 0.068463 0.069573 0.137314 0.138211 0.138819 0.153146 0.021748 0.073014 0.074926 0.085058 0.063745 0.064662 0.109468 0.155438 0.062987 0.064509 0.066635 0.069979 0.064545 0.072802 0.076907 0.077792 0.064384 0.069148 0.078548 0.098692 0.065691 0.066708 0.071664 0.076864"\n2017-12-31T01:17:54Z	500	0.10964786111111109	true	0.061	0.158	ms	"0.090455 0.090714 0.091627 0.101865 0.08969 0.089739 0.096543 0.09965 0.207336 0.208108 0.211237 0.216649 0.087916 0.091176 0.093013 0.099231 0.090032 0.091853 0.111328 0.130319 0.015198 0.05727 0.095563 0.220208 0.095655 0.096207 0.098334 0.103475 0.091457 0.094556 0.094969 0.099145 0.094538 0.095998 0.102323 0.103946"\n2017-12-31T01:17:54Z	700	0.12467650000000002	true	0.105	0.145	ms	"0.118089 0.118241 0.121727 0.123906 0.100369 0.121828 0.122606 0.124863 0.126032 0.133865 0.163573 0.184979 0.116554 0.118467 0.120884 0.126521 0.119773 0.12152 0.123441 0.125055 0.120302 0.12076 0.125011 0.128407 0.12027 0.122501 0.1281 0.138795 0.117312 0.117686 0.120112 0.127351 0.055578 0.130398 0.141535 0.141943"\n2017-12-31T01:17:54Z	900	0.15044702777777777	true	0.119	0.182	ms	"0.144732 0.14499 0.158195 0.16483 0.121107 0.151033 0.151088 0.153996 0.154981 0.159305 0.175039 0.198159 0.147772 0.149289 0.152299 0.154377 0.14381 0.144348 0.156647 0.167778 0.079173 0.085338 0.085622 0.096801 0.162955 0.165825 0.188939 0.209996 0.154451 0.156877 0.159356 0.159895 0.108649 0.158604 0.161809 0.188028"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.11971302777777776	true	0.054	0.186	ms	"0.074012 0.081532 0.129706 0.232614 0.078145 0.08116 0.081906 0.086313 0.074299 0.09053 0.284932 0.328431 0.125775 0.135537 0.137378 0.138159 0.02823 0.070175 0.070548 0.126057 0.098505 0.101421 0.122447 0.123512 0.078629 0.08786 0.102857 0.130769 0.071815 0.143091 0.14398 0.204106 0.066743 0.098192 0.104586 0.175717"\n2017-12-31T01:17:54Z	300	0.12937463888888887	true	0.096	0.163	ms	"0.106616 0.106753 0.108903 0.138998 0.097819 0.102088 0.105507 0.112637 0.120884 0.134178 0.180821 0.212323 0.097676 0.098598 0.120425 0.145702 0.103701 0.111577 0.121422 0.126486 0.180767 0.180769 0.186543 0.190181 0.106851 0.108395 0.116279 0.124184 0.106889 0.14063 0.145531 0.158489 0.103257 0.105013 0.116152 0.134443"\n2017-12-31T01:17:54Z	500	0.15794841666666665	true	0.116	0.200	ms	"0.14376 0.152553 0.152654 0.156199 0.125634 0.132878 0.133208 0.13727 0.156399 0.157595 0.159976 0.168564 0.124911 0.125017 0.129636 0.133053 0.131208 0.140084 0.181308 0.189932 0.253186 0.255514 0.261042 0.262847 0.133651 0.135466 0.153245 0.163222 0.126233 0.142012 0.143831 0.1713 0.133731 0.13395 0.139156 0.145918"\n2017-12-31T01:17:54Z	700	0.19306108333333336	true	0.134	0.252	ms	"0.162345 0.16594 0.209659 0.210974 0.155462 0.159013 0.168322 0.170243 0.118672 0.161456 0.165891 0.18869 0.143014 0.144121 0.158759 0.161971 0.151698 0.154344 0.218865 0.223099 0.325631 0.325994 0.327259 0.329645 0.16474 0.209199 0.217959 0.228915 0.172225 0.177547 0.189088 0.195154 0.151251 0.170351 0.172112 0.200591"\n2017-12-31T01:17:54Z	900	0.19371572222222222	true	0.155	0.232	ms	"2.8E-5 0.184386 0.195665 0.209605 0.189206 0.193906 0.209195 0.224647 0.184886 0.186163 0.188462 0.196357 0.181478 0.185198 0.213276 0.220366 0.187261 0.190005 0.207338 0.231956 0.202799 0.204713 0.205716 0.210044 0.174651 0.194391 0.201404 0.211052 0.182528 0.194189 0.198288 0.216343 0.189414 0.19057 0.199511 0.218769"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.5120665277777777	true	0.178	0.846	ms	"0.195281 0.441468 0.447073 0.53103 0.363559 0.400377 0.418682 0.428352 0.397045 0.405376 0.410749 0.435022 0.420082 0.506355 0.508642 0.549618 0.431936 0.484811 0.515008 0.553988 0.345258 0.450418 0.51709 0.657051 0.472692 0.490939 0.493227 0.576532 0.410155 0.595909 0.924164 2.185191 0.304939 0.351049 0.403885 0.411442"\n2017-12-31T01:17:54Z	300	0.5299853055555556	true	0.406	0.654	ms	"0.341683 0.530769 0.600001 0.607485 0.440857 0.529702 0.543513 0.564188 0.228849 0.471161 0.482982 0.61529 0.563441 0.669948 0.689239 0.749975 0.421735 0.464603 0.46778 0.469338 0.544873 0.586208 0.588219 0.642801 0.474205 0.500999 0.625489 0.755503 0.461166 0.512606 0.567107 0.727928 0.396837 0.40576 0.407041 0.43019"\n2017-12-31T01:17:54Z	500	0.4801600555555555	true	0.344	0.616	ms	"0.436114 0.443573 0.444839 0.445773 0.398989 0.476122 0.512987 0.521011 0.123663 0.451117 0.526465 0.537591 0.630687 0.640508 0.671785 0.719724 0.29616 0.487558 0.531871 0.547671 0.492812 0.521236 0.528543 0.566216 0.423851 0.43832 0.453954 0.458256 0.495455 0.501857 0.553136 0.560882 0.043482 0.429348 0.456948 0.517258"\n2017-12-31T01:17:54Z	700	0.519014361111111	true	0.414	0.624	ms	"0.421844 0.446257 0.455833 0.462228 0.353302 0.518488 0.529063 0.616936 0.466664 0.469973 0.509313 0.542373 0.596963 0.632079 0.662686 0.756852 0.507716 0.564503 0.568064 0.641067 0.464103 0.547142 0.55634 0.596527 0.452762 0.474922 0.498387 0.49868 0.559657 0.565087 0.567205 0.616393 0.198352 0.446284 0.456259 0.464213"\n2017-12-31T01:17:54Z	900	0.5338772500000001	true	0.388	0.679	ms	"0.429614 0.439699 0.468115 0.490151 0.512205 0.517062 0.535487 0.555111 0.528823 0.532238 0.564585 0.606965 0.524372 0.5806 0.604034 0.642261 0.486473 0.492276 0.506348 0.532688 0.553702 0.566536 0.568048 0.574855 0.485329 0.508203 0.529138 0.551663 0.480817 0.519905 0.522684 0.529534 0.139016 0.468469 0.500111 1.172464"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.03543152777777778	true	0.021	0.050	ms	"0.029211 0.030335 0.030344 0.032261 0.028998 0.030387 0.035825 0.037496 0.027916 0.029222 0.029295 0.030608 0.038795 0.040231 0.04454 0.048146 4.0E-6 9.0E-6 0.061227 0.075949 0.034682 0.035538 0.036001 0.036602 0.038014 0.040518 0.043233 0.04915 0.027543 0.027738 0.029317 0.030732 0.037461 0.03866 0.042876 0.046671"\n2017-12-31T01:17:54Z	300	0.0642178888888889	true	0.048	0.081	ms	"0.049578 0.050483 0.051898 0.053599 0.049002 0.052282 0.058261 0.058853 0.048828 0.050077 0.063655 0.064863 0.042262 0.079969 0.081378 0.09512 0.059945 0.062242 0.073415 0.094935 0.055137 0.055232 0.05708 0.05771 0.077722 0.080324 0.081154 0.081356 0.04784 0.048205 0.049832 0.050364 0.076232 0.077217 0.08782 0.087974"\n2017-12-31T01:17:54Z	500	0.08695758333333332	true	0.061	0.113	ms	"0.070603 0.071984 0.074026 0.077463 0.068423 0.070885 0.070951 0.071355 0.068549 0.069464 0.070078 0.070701 0.105275 0.121381 0.121397 0.121971 0.068553 0.069641 0.089198 0.118256 0.069172 0.076938 0.079788 0.097065 0.115755 0.118098 0.119989 0.124047 0.068357 0.06909 0.069286 0.069744 0.029456 0.115235 0.11819 0.120109"\n2017-12-31T01:17:54Z	700	0.10851633333333334	true	0.071	0.146	ms	"0.092739 0.092861 0.096134 0.096825 0.089053 0.090088 0.090298 0.091372 0.080693 0.090372 0.092718 0.093528 0.157756 0.158921 0.163342 0.169463 0.090376 0.092568 0.092686 0.095284 0.08388 0.084976 0.085846 0.087346 0.019382 0.15298 0.153169 0.157827 0.087595 0.089809 0.090051 0.091511 0.149504 0.150006 0.150614 0.155015"\n2017-12-31T01:17:54Z	900	0.13374875	true	0.085	0.183	ms	"0.110745 0.113817 0.120277 0.121515 0.11061 0.110947 0.134117 0.138061 0.109522 0.110496 0.111074 0.113157 0.18193 0.192886 0.207824 0.207861 0.113473 0.113883 0.114458 0.115311 0.077592 0.10489 0.105987 0.120978 0.028514 0.057612 0.192837 0.199973 0.104007 0.114229 0.114835 0.139128 0.187883 0.191036 0.194917 0.228573"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.1264330555555556	true	0.073	0.179	ms	"0.086045 0.098313 0.102346 0.127577 0.087385 0.090618 0.125616 0.130176 0.104001 0.127492 0.136208 0.157109 0.101113 0.142993 0.16781 0.25309 0.101961 0.115976 0.162399 0.257162 0.087745 0.100737 0.122637 0.143746 0.075365 0.08321 0.104696 0.126576 1.03E-4 0.086655 0.092516 0.211728 0.133656 0.153408 0.169387 0.184035"\n2017-12-31T01:17:54Z	300	0.24957880555555548	true	0.181	0.318	ms	"0.161835 0.183095 0.186975 0.229141 0.201211 0.241943 0.255983 0.265294 0.20786 0.247643 0.336499 0.383428 0.241815 0.283921 0.303932 0.319198 0.209858 0.230097 0.252669 0.270855 0.176512 0.181737 0.194502 0.198419 0.204789 0.2448 0.250493 0.251163 0.228631 0.243056 0.26288 0.289933 0.172588 0.272595 0.317971 0.481516"\n2017-12-31T01:17:54Z	500	0.2888886944444444	true	0.232	0.346	ms	"0.159725 0.252512 0.260363 0.291741 0.281162 0.285686 0.293119 0.32155 0.136052 0.296187 0.29853 0.328486 0.305669 0.336242 0.370079 0.39188 0.271902 0.28189 0.354999 0.358709 0.240745 0.270062 0.274275 0.283149 0.181593 0.265026 0.275954 0.295783 0.275528 0.284082 0.287866 0.359522 0.292362 0.301376 0.309906 0.326281"\n2017-12-31T01:17:54Z	700	0.4125130277777778	true	0.355	0.470	ms	"0.342609 0.344064 0.359981 0.366836 0.400506 0.422521 0.44378 0.457893 0.421164 0.42197 0.449919 0.4524 0.361702 0.383284 0.44137 0.501296 0.374729 0.383434 0.39147 0.40193 0.377916 0.408474 0.429554 0.476127 0.362393 0.400558 0.408703 0.481902 0.377496 0.387553 0.414881 0.433686 0.285947 0.426 0.484333 0.572088"\n2017-12-31T01:17:54Z	900	0.5036493055555555	true	0.403	0.604	ms	"0.414268 0.485063 0.647275 0.655629 0.339026 0.475312 0.49619 0.589575 0.376812 0.487895 0.495971 0.535526 0.332923 0.469489 0.48592 0.550744 0.480974 0.561028 0.65159 0.816099 0.453223 0.488973 0.522616 0.583142 0.432995 0.446005 0.455813 0.459851 0.469574 0.516064 0.527066 0.543055 0.408134 0.427315 0.513693 0.536547"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.5686531944444444	true	0.351	0.786	ms	"0.207719 0.34621 0.386771 0.459503 0.464555 0.589651 0.748484 1.052071 0.425103 0.609112 0.668324 0.668729 0.447191 0.505598 0.531018 0.651 0.436309 0.524265 0.746965 0.813287 0.431235 0.437992 0.558476 0.703625 0.485157 0.500911 0.588562 0.609401 0.462724 0.488356 0.756228 0.988924 0.061838 0.500393 0.623524 0.992304"\n2017-12-31T01:17:54Z	300	1.2120966388888885	true	0.838	1.586	ms	"0.522604 0.602952 0.614983 0.638239 1.370768 1.398943 1.421378 1.444964 0.5465 0.932549 0.960484 1.103087 1.356607 1.399895 1.562013 1.809795 1.095056 1.13438 1.300177 1.327194 0.81664 1.136467 1.460632 2.072318 1.355994 1.375708 1.381208 1.702022 1.025765 1.193535 1.247543 1.31605 1.175584 1.248554 1.282311 1.30258"\n2017-12-31T01:17:54Z	500	1.8084392500000002	true	1.218	2.399	ms	"0.731874 0.860585 0.874951 0.991366 1.781782 2.090593 2.206689 2.362559 1.036576 1.132499 1.30217 1.584935 1.821529 2.225852 2.38206 2.958551 1.839142 1.875973 1.941524 2.443202 1.623282 1.681554 1.969028 2.484712 1.776579 1.853021 2.417313 2.774952 1.686035 1.896114 2.146351 2.373186 1.379068 1.381258 1.557194 1.659754"\n2017-12-31T01:17:54Z	700	2.16445075	true	1.429	2.900	ms	"1.036205 1.164166 1.17488 1.394031 2.509858 2.695938 2.702991 2.795032 1.456703 1.465756 1.772253 2.152615 2.584571 3.099858 3.587578 3.903169 1.297925 1.471485 1.487247 1.510829 2.067184 2.188902 2.220602 2.379177 2.316289 2.35362 2.45663 2.585124 2.050648 2.147536 2.622481 3.037901 1.697966 1.745214 2.120417 2.667446"\n2017-12-31T01:17:54Z	900	2.6812606111111115	true	1.704	3.658	ms	"1.454401 1.457904 1.46474 1.472244 3.225323 3.397067 3.497103 3.782987 1.918115 1.923842 2.519776 2.982631 3.778813 3.992951 4.633108 4.788868 1.305597 1.562497 1.679051 2.258274 2.554793 2.815303 2.816958 2.904194 2.445595 2.946715 3.594542 3.692425 2.204592 2.475257 2.889938 3.032927 2.107829 2.18051 2.211827 2.556685"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.053294527777777795	true	0.040	0.066	ms	"0.041566 0.04179 0.050957 0.051302 0.037079 0.037425 0.042596 0.048435 0.053428 0.058539 0.068485 0.074123 0.030841 0.046263 0.062564 0.083815 0.049013 0.050942 0.053382 0.053708 0.049676 0.056399 0.067521 0.079541 0.037168 0.04755 0.050002 0.051215 0.046499 0.050484 0.052175 0.055563 0.049272 0.052457 0.065377 0.071451"\n2017-12-31T01:17:54Z	300	0.08579358333333334	true	0.049	0.122	ms	"0.052857 0.053564 0.053571 0.0538 0.048675 0.049852 0.05012 0.051129 0.049915 0.050637 0.113805 0.133751 0.049691 0.050347 0.050417 0.051492 0.083716 0.084961 0.085827 0.093552 0.10583 0.109071 0.114757 0.121155 0.081115 0.106757 0.115836 0.11726 0.097462 0.101965 0.102254 0.106861 0.07575 0.109302 0.116551 0.194964"\n2017-12-31T01:17:54Z	500	0.1101591388888889	true	0.055	0.165	ms	"3.0E-6 1.6E-5 0.07006 0.102275 0.072849 0.085059 0.086341 0.100155 0.071304 0.072681 0.075201 0.077655 0.068214 0.072288 0.072806 0.096163 0.07622 0.076786 0.078014 0.078141 0.080524 0.160552 0.186208 0.202725 0.164159 0.165542 0.166309 0.169116 0.152793 0.15603 0.161 0.161629 0.108077 0.165445 0.166029 0.16736"\n2017-12-31T01:17:54Z	700	0.17257883333333338	true	0.016	0.329	ms	"0.092718 0.092882 0.093636 0.093798 0.087593 0.090015 0.091268 0.092499 0.089204 0.094045 0.226567 0.826274 0.089234 0.089974 0.090796 0.096403 0.092104 0.092502 0.094598 0.097046 0.07785 0.232098 0.258469 0.300287 0.161355 0.162331 0.177992 0.199104 0.089381 0.19794 0.210393 0.540159 0.210523 0.221973 0.22652 0.233307"\n2017-12-31T01:17:54Z	900	0.1903416388888889	true	0.082	0.299	ms	"0.110872 0.114224 0.11486 0.117816 0.109336 0.110955 0.111906 0.111967 0.064946 0.112352 0.215018 0.599554 0.113262 0.116279 0.132714 0.162039 0.115118 0.11726 0.11832 0.11978 0.271381 0.271925 0.272959 0.294371 0.156887 0.205109 0.209389 0.211769 0.256978 0.263704 0.266717 0.267599 0.163847 0.281187 0.283248 0.286651"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.14719169444444444	true	0.069	0.226	ms	"0.061102 0.078532 0.205128 0.344729 0.123573 0.140508 0.1806 0.26975 0.119197 0.120928 0.175974 0.176971 0.166214 0.203991 0.213487 0.217658 0.105101 0.1235 0.125232 0.137372 0.111207 0.111404 0.242384 0.284104 0.087012 0.089654 0.105496 0.125632 0.005869 0.09826 0.100043 0.117346 0.039604 0.096802 0.120263 0.274274"\n2017-12-31T01:17:54Z	300	0.26805377777777784	true	0.166	0.370	ms	"0.347569 0.349393 0.376644 0.386061 0.232941 0.244662 0.278982 0.288689 0.243575 0.274038 0.304608 0.310021 0.275537 0.277511 0.431307 0.533539 0.078079 0.18764 0.188176 0.261804 0.212823 0.219803 0.40135 0.425539 0.134859 0.180836 0.189256 0.26701 0.137816 0.184391 0.1956 0.276013 0.189436 0.191394 0.249658 0.323376"\n2017-12-31T01:17:54Z	500	0.38633874999999995	true	0.093	0.680	ms	"0.475844 0.487736 0.907707 1.82483 0.326253 0.376111 0.393207 0.469476 0.286095 0.292643 0.401324 0.417384 0.207346 0.289092 0.309576 0.340845 0.271151 0.277218 0.305048 0.323472 0.240513 0.333928 0.340801 0.368321 0.274561 0.283162 0.301497 0.305178 0.249096 0.269803 0.285596 0.319524 0.30281 0.336727 0.346712 0.367608"\n2017-12-31T01:17:54Z	700	0.5111134166666668	true	0.188	0.835	ms	"0.664049 0.672544 0.706809 0.758823 0.304194 0.369111 0.377119 0.384103 0.325797 0.418606 0.491254 0.574499 0.375006 0.377861 0.875323 1.920529 0.32987 0.378928 0.596451 1.073192 0.452322 0.454449 0.514815 0.556618 0.147481 0.28369 0.416416 0.519937 0.367571 0.375504 0.377776 0.386767 0.358556 0.381171 0.410948 0.421994"\n2017-12-31T01:17:54Z	900	0.5284206388888889	true	0.401	0.655	ms	"0.609488 0.801577 0.818085 0.904598 0.421305 0.46114 0.547157 0.55064 0.488479 0.494115 0.502766 0.506082 0.468931 0.473506 0.475126 0.512612 0.356879 0.387675 0.484052 0.492265 0.459579 0.510686 0.523896 0.599496 0.495846 0.503376 0.514668 0.523252 0.356125 0.483966 0.514961 0.749588 0.478931 0.490566 0.530129 0.5316"\n', 'date	param-arraySize	value	success	cilo	cihi	units	complete\n2017-12-31T01:17:54Z	100	0.6402840555555556	true	0.381	0.900	ms	"1.6E-5 0.402688 0.623968 1.345909 0.487119 0.624657 0.667833 0.721467 0.503882 0.567913 0.619893 0.691627 0.717523 0.720045 0.768287 0.794275 0.825865 0.905057 0.907421 0.951271 0.344635 0.400788 0.795146 1.160373 0.605632 0.61957 0.633252 0.729544 0.47044 0.527697 0.537219 0.636232 0.389574 0.394321 0.451709 0.507378"\n2017-12-31T01:17:54Z	300	1.5223316666666664	true	1.141	1.903	ms	"0.866352 1.047153 1.38558 2.055026 1.353064 1.662781 1.771994 1.831331 1.279403 1.327942 1.688461 2.003709 1.848709 1.851997 1.97567 1.979548 1.190161 1.255778 1.432868 1.447504 0.946817 1.114762 1.359081 1.874719 1.445334 1.677934 2.055987 2.300886 1.14646 1.290813 1.421226 1.707139 1.191428 1.275178 1.347288 1.393857"\n2017-12-31T01:17:54Z	500	2.2769619999999997	true	1.575	2.979	ms	"1.574052 1.78629 1.865166 2.038134 2.082081 2.2855 2.412645 2.6171 1.963475 2.143617 2.361089 2.366501 2.927987 3.169648 3.376037 3.573026 1.480461 1.583947 1.608257 1.792262 1.258705 1.360847 1.43918 1.471274 2.791003 3.090636 3.157988 3.53465 1.82717 1.870769 2.674108 2.978356 2.126528 2.414593 2.448125 2.519425"\n2017-12-31T01:17:54Z	700	2.958827277777777	true	1.943	3.974	ms	"1.665808 1.803042 2.397012 2.861147 3.006655 3.294705 3.666206 3.738519 2.577432 2.602684 2.714164 2.872245 3.633192 4.044264 4.175351 4.475069 2.121195 2.463115 2.680781 3.166122 1.507155 1.547929 1.559109 1.580722 3.880151 4.160523 4.906832 5.106925 2.64678 2.816589 2.870554 2.915032 2.330281 2.368401 2.994434 3.367657"\n2017-12-31T01:17:54Z	900	3.5263304444444445	true	2.156	4.896	ms	"2.446501 2.74366 2.937397 3.030638 2.989418 3.407276 3.596105 3.660068 3.242299 3.383472 3.662461 4.008674 5.38053 5.61089 5.675536 5.817013 1.607312 1.857267 2.381581 2.609009 1.773792 2.030856 2.064743 2.570821 4.291496 5.226257 5.829614 6.523549 3.015601 3.285319 3.554991 3.640591 2.822476 3.096373 3.388732 3.785578"\n'];
  parent[my.name] = my;
  return parent;
})(ScalaMeter || {});