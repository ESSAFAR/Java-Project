DROP DATABASE IF EXISTS departement;
CREATE DATABASE departement;
USE departement;
-- Structure de la table `agent _scolarite`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `Id_scola` int(11) NOT NULL,
  `mot_de_passe` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO admin (nom, prenom, Id_scola, mot_de_passe, email) VALUES
('2', '2', 100, '2', 'john.smith@school.edu'),
('Doe', 'Jane', 101, 'password2', 'jane.doe@school.edu'),
('Johnson', 'Mark', 102, 'password3', 'mark.johnson@school.edu'),
('Williams', 'Mary', 103, 'password4', 'mary.williams@school.edu'),
('Garcia', 'Luis', 104, 'password5', 'luis.garcia@school.edu'),
('Brown', 'Samantha', 105, 'password6', 'samantha.brown@school.edu'),
('Jones', 'David', 106, 'password7', 'david.jones@school.edu'),
('Miller', 'Emily', 107, 'password8', 'emily.miller@school.edu'),
('Wilson', 'Ryan', 108, 'password9', 'ryan.wilson@school.edu'),
('Taylor', 'Olivia', 109, 'password10', 'olivia.taylor@school.edu');

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

DROP TABLE IF EXISTS `avis`;
CREATE TABLE IF NOT EXISTS `avis` (
  `id_avis` int(11) NOT NULL,
  `objet` varchar(50) NOT NULL,
  `contenu` varchar(200) NOT NULL,
  `date_creation` date NOT NULL,
  PRIMARY KEY (`id_avis`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `demandedocument`
--

DROP TABLE IF EXISTS `demandedocument`;
CREATE TABLE IF NOT EXISTS `demandedocument` (
  `id_demande` int(11) NOT NULL,
  `objet` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `etat` varchar(15) NOT NULL DEFAULT 'incomplet',
  `date_demande` date NOT NULL,
  PRIMARY KEY (`id_demande`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `element_module`
--

DROP TABLE IF EXISTS `element_module`;
CREATE TABLE IF NOT EXISTS `element_module` (
  `id_element` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `id_module` varchar(20) NOT NULL,
  `id_prof` varchar(20) NOT NULL,
  PRIMARY KEY (`id_element`,`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `cin` varchar(10) NOT NULL,
  `mot_de_passe` varchar(20) NOT NULL,
  `matricule` int(11) NOT NULL,
  `cne` varchar(20) NOT NULL,
  `genre` varchar(15) NOT NULL,
  `date_naissance` date NOT NULL,
  `lieu_naissance` varchar(10) NOT NULL,
  `nationalite` varchar(15) NOT NULL DEFAULT 'marocaine',
  `promotion` varchar(2) NOT NULL DEFAULT '1A',
  `email institutionnel` varchar(30) NOT NULL DEFAULT 'nom.prenom@student.emi.ac.ma',
  `telephone` int(14) NOT NULL,
  `adresse` varchar(120) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
INSERT INTO etudiant (nom, prenom, cin, mot_de_passe, matricule, cne, genre, date_naissance, lieu_naissance, nationalite, promotion, `email institutionnel`, telephone, adresse) VALUES ('1', '1', '1', '1', 10001, 'CNE123456', 'M', '2000-01-01', 'Rabat', 'marocaine', '1A', 'john.smith@student.emi.ac.ma', 0612345678, '1 Avenue Hassan II, Rabat');





-- --------------------------------------------------------

--
-- Structure de la table `module_semestre`
--

DROP TABLE IF EXISTS `module_semestre`;
CREATE TABLE IF NOT EXISTS `module_semestre` (
  `id_module` varchar(20) NOT NULL,
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`id_module`,`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `id_prof` int(11) NOT NULL,
  `mot_de_passe` varchar(20) NOT NULL,
  `CIN` varchar(10) NOT NULL,
  `specialite` varchar(25) NOT NULL,
  `type_contrat` varchar(15) NOT NULL,
  `data_embauche` date NOT NULL,
  `email` varchar(20) NOT NULL,
  `telephone` int(14) NOT NULL,
  `bureau` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `resultat_element`
--

DROP TABLE IF EXISTS `resultat_element`;
CREATE TABLE IF NOT EXISTS `resultat_element` (
  `id_element` varchar(20) NOT NULL,
  `id_etudiant` varchar(20) NOT NULL,
  `note` float NOT NULL,
  PRIMARY KEY (`id_element`,`id_etudiant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `resultat_module`
--

DROP TABLE IF EXISTS `resultat_module`;
CREATE TABLE IF NOT EXISTS `resultat_module` (
  `id_module` varchar(20) NOT NULL,
  `note` float NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  PRIMARY KEY (`id_etudiant`,`id_module`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;
